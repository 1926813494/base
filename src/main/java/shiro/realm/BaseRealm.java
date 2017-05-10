package shiro.realm;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wewills.base.sys.model.SysPermission;
import com.wewills.base.sys.service.SysService;
import com.wewills.base.user.model.User;
import com.wewills.base.user.service.UserService;

public class BaseRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseRealm.class);
	
	@Resource
	private UserService userService;
	
	@Resource
	private SysService sysService;
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户名
		String userCode = (String) token.getPrincipal();
		logger.info("doGetAuthenticationInfo--->"+userCode+":"+token.getCredentials());
		//根据用户输入的userCode从数据库查询
		User user = userService.getById(userCode);
		if(user != null) {
			if(user.getLocked() == 1) {
				//账号被锁定
				throw new LockedAccountException();
			}else {
				String dbPwd = user.getPassword(); //密码
				String salt = user.getSalt(); //盐
				//取出用户的所有菜单
				List<SysPermission> menus = sysService.findMenuListByUserId(user.getId());
				user.setMenus(menus);
				SimpleAuthenticationInfo simpleAuthenticationInfo = 
						new SimpleAuthenticationInfo(user, dbPwd, ByteSource.Util.bytes(salt), getName());				
				return simpleAuthenticationInfo;
			}
		}else {
			//没找到账号
			throw new UnknownAccountException();
		}
	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//从 principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型）
		User user = (User) principals.getPrimaryPrincipal();
		logger.info("认证---doGetAuthorizationInfo--->"+user.getUsercode());
		Set<String> percodes = sysService.findPercode(user.getId());
		logger.info("拥有的权限："+percodes);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setStringPermissions(percodes);
		return simpleAuthorizationInfo;
	}

}
