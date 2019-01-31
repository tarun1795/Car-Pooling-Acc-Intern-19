package com.accolite.carpooling.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.UserDao;
import com.accolite.carpooling.models.User;
import com.accolite.carpooling.rowmappers.UserMapper;

/**
 * User DAO for user related queries
 *
 */
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * returns a single user with user id = id
	 */
	@Override
	public User getUser(int id) {
		try {
			return jdbcTemplate.queryForObject(Query.SQL_GET_USER_BY_ID, new Object[] { id }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * returns a list of all users
	 */
	@Override
	public List<User> getAllUsers() {
		return jdbcTemplate.query(Query.SQL_GET_USERS, new UserMapper());
	}

	/**
	 * used to create a new user
	 */
	@Override
	public boolean createUser(User login) {
		return jdbcTemplate.update(Query.SQL_CREATE_USER, login.getUserId(), login.getUserId(),
				login.getUserName()) > 0;
	}

	/**
	 * used to update an existing user
	 */
	@Override
	public boolean updateUser(User login,int user_id) {
		return jdbcTemplate.update(Query.SQL_UPDATE_USER,  login.getEmail(), login.getPassword(),  login.getUserName(), user_id) > 0;
	}

	/**
	 * deletes an existing user
	 */
	@Override
	public boolean deleteUser(int id) {
		return jdbcTemplate.update(Query.SQL_DELETE_USER, id) > 0;
	}	

	/**
	 * used for logging in a user
	 */
	@Override
	public boolean login(String email, String password) {
		
			User user = jdbcTemplate.queryForObject(Query.SQL_USER_VALIDATE, new Object[] { email, password },
					new UserMapper());
			System.out.println(user);
			return true;
//		} catch (Exception e) {
//			return false;
//		}
	}

	/**
	 * used to create a new user 
	 */
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
//		System.out.println(user.getWalletId());
		return jdbcTemplate.update(Query.SQL_CREATE_USER,  user.getEmail(),user.getPassword() ,user.getWalletId(), user.getUserName() ) > 0;
	}

}
