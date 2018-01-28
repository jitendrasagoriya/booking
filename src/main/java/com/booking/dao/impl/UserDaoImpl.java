package com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.booking.dao.UserDao;
import com.booking.entity.User;
import com.booking.mapper.UserMapper;
import com.mysql.jdbc.Statement;

 
@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${user.insert}")
	private String userCreate;

	@Value("${user.select.all}")
	private String userAll;
	
	@Value("${user.select.id}")
	private String userById;
	
	@Value("${user.register}")
	private String userReg;
	
	@Value("${user.login}")
	private String userLogin;
	
	@Override
	public User create(final User user) {
		logger.info("*************** CREATING NEW USER *******************");
		
		logger.info("SQL :"+userCreate);
		logger.info("VALUES :"+ new StringBuffer(user.getName()).append(",")
				.append(user.getEmail()).append(",").append(user.getPassword()));
		
	 	KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(userCreate, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				return ps;
			}
		},holder);
		
		int newUserId = holder.getKey().intValue();
		user.setId(newUserId);
		
		logger.info("*************** CREATING NEW USER *******************");
		return user;
	}

	@Override
	public List<User> getUser() {
		logger.info("*************** GET ALL USER *******************");
		
		logger.info("SQL :"+userAll);
		List<User> users = jdbcTemplate.query(userAll,new UserMapper());
		 
		 
		return users;
	}

	@Override
	public User getUserById(long id) {
		logger.info("*************** GET USER BY ID*******************");
		
		logger.info("SQL :"+userById);
		logger.info("VALUES :"+id);
		List<User> users = jdbcTemplate.query(userById,  new Object[] {id} ,new UserMapper());	 
		 
		return users.get(0);
	}

	@Override
	public int registerUser(long id) {
		logger.info("*************** REGISTER USER*******************");
		
		logger.info("SQL :"+userReg);
		logger.info("VALUES :"+id);
		int result = jdbcTemplate.update(userReg, new Object[] {id} );
		 
		return result;
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		logger.info("*************** GET USER BY Email And Password*******************");
		
		logger.info("SQL :"+userLogin);
		logger.info("VALUES :"+ email +","+password);
		List <User> users = jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(userLogin);
				ps.setString(1, email);
				ps.setString(2, password);
				return ps;
			}
		}, new UserMapper());
		 
		return users.get(0);
	}

	
	
}
