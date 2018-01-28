package com.booking.dao;

import java.util.List;

import com.booking.entity.User;

public interface UserDao {
		public User create(User user);
		public List<User> getUser();
		public User getUserById(long id);
		public int registerUser(long id);
		public User getUserByEmailAndPassword(String email, String password);
}
