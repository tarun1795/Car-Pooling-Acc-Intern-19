package com.accolite.carpooling.services.interfaces;

import java.util.List;

import com.accolite.carpooling.dto.UserDetailDto;
import com.accolite.carpooling.models.User;

/**
 * user related services can be accessed using UserService
 *
 */
public interface UserService {

	/**
	 * returns a user
	 * 
	 * @param id user id
	 * @return
	 */
	User getUser(int id);

	/**
	 * returns user and vehicle info
	 * 
	 * @param id user id
	 * @return UserDetails object
	 */
	UserDetailDto getUserDetail(int id);

	/**
	 * updates user and vehicles
	 * 
	 * @param userDetails user details object
	 * @return return true or false
	 */
	boolean updateUserDetail(UserDetailDto userDetails);

	/**
	 * creates a new user
	 * 
	 * @param login login object
	 * @return
	 */
	boolean createUser(User login);

	/**
	 * deletes an existing user
	 * 
	 * @param id user id
	 * @return
	 */
	boolean deleteUser(int id);

	/**
	 * updates an existing user
	 * 
	 * @param user   user object
	 * @param userId user id
	 * @return returns true or false
	 */
	boolean updateUser(User user, int userId);

	/**
	 * logs user in
	 * 
	 * @param email    user email
	 * @param password user password
	 * @return valid or not valid user
	 */
	boolean login(String email, String password);

	/**
	 * returns list of all users
	 * 
	 * @return
	 */
	List<User> getAllUsers();

	/**
	 * adds a new user
	 * 
	 * @param user
	 * @return
	 */
	boolean addUser(User user);
}