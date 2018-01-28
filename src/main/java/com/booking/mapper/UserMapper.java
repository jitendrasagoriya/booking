package com.booking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.booking.entity.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		User user = new User();
		
		user.setEmail(resultSet.getString("EMAIL"));
		user.setId(resultSet.getInt("ID"));
		user.setLastLogin(resultSet.getTimestamp("LST_LOGIN"));
		user.setName(resultSet.getString("NAME"));
		user.setRegDate(resultSet.getTimestamp("REG_DT"));
		user.setRegistered(resultSet.getBoolean("IS_REG"));
		return user;
	}

}
