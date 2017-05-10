package shiro.credential;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordHashedCredentialsMatcher {

	private int hashIterations = 1; //hash次数,默认次数：1
		
	private String algorithmName = "md5"; //使用加密的方式，例如：md5
	
	/**
	 * 对指定源进行hash
	 * @author 刘坤耀
	 * @createTime 2017年5月10日 上午9:24:04
	 * @param source hash的源
	 * @param salt 加入的盐
	 * @return
	 */
	public String hashed(Object source,String salt) {
		SimpleHash simpleHash = new SimpleHash(this.algorithmName, source, salt, this.hashIterations);
		return simpleHash.toHex();
	}
	
	/**
	 * 默认次数：1
	 * @author 刘坤耀
	 * @createTime 2017年5月10日 上午9:25:32
	 * @param hashIterations
	 */
	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	/**
	 * 默认使用md5
	 * @author 刘坤耀
	 * @createTime 2017年5月10日 上午9:25:51
	 * @param algorithmName
	 */
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
}
