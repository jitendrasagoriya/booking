package com.booking.Booking;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.booking.dao.UserDao;
import com.booking.entity.User;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void createUser() {
		User user = new User();
		user.setEmail("test@test.com");
		user.setId(1);
		user.setName("testName");
		user.setPassword( "password");
		
		user = userDao.create(user);
		
		Assert.assertNotNull(user);
		Assert.assertEquals(3, user.getId());
	}
	
	@Test
	public void getAllUser() {
		List<User> users = userDao.getUser();
		Assert.assertNotNull(users);
		Assert.assertEquals(3, users.size());
		
	}
	
	@Test
	public void getUserById() {
		User users = userDao.getUserById(2) ;
		Assert.assertNotNull(users);
		Assert.assertEquals("Mannu ram", users.getName());
		
	}
	
	@Test
	public void getRegisterUser() {
		int result = userDao.registerUser(2);
		User users = userDao.getUserById(2) ;
		Assert.assertNotNull(users);
		Assert.assertEquals(true, users.isRegistered());
		
	}
	
	@Test
	public void getUserByEmailAndPwd() {
		User users = userDao.getUserByEmailAndPassword("jiendrasagoriya@yahoo.co.in", "123456");
		Assert.assertNotNull(users);
		Assert.assertEquals("jitendra sagoriya", users.getName());
		Assert.assertEquals(1, users.getId());
	}

}
