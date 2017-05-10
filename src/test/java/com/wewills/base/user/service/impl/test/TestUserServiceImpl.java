package com.wewills.base.user.service.impl.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wewills.base.user.model.User;
import com.wewills.base.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class TestUserServiceImpl {

	@Resource
	private UserService userService;
	
	@Test
	public void testSave() {
		User user = new User();
		userService.save(user);
		System.out.println(user);
	}
	
}
