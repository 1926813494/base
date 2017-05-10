package com.wewills.base.user.mapper.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wewills.base.user.mapper.UserMapper;
import com.wewills.base.user.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class TestUserMapper {
	
	@Resource
	private UserMapper userMapper;
	
	@Test
	public void testSave() {
		User user = new User();
		userMapper.save(user);
	}
	
}
