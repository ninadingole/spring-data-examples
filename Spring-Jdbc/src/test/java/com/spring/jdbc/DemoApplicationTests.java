package com.spring.jdbc;

import com.spring.jdbc.config.DbConfig;
import com.spring.jdbc.dao.UserDao;
import com.spring.jdbc.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(properties = {"classpath:application-test.properties"})
@PropertyMapping("classpath:application-test.properties")
public class DemoApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setPassword("hello");
		user.setUsername("admin");
		int val = userDao.addUser(user);
		Assert.assertEquals(1,1);
	}

	@Test
	public void testUserExists(){
		User user = this.userDao.getUser("admin");
		Assert.assertNotNull(user);
		Assert.assertEquals("admin",user.getUsername());
	}
}
