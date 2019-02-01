package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.User;

/**
 * row mapper for user
 *
 */
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		User user = new User();
		user.setUserId(rs.getInt("u_id"));
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setWalletId(rs.getInt("w_id"));
		return user;

	}

}
