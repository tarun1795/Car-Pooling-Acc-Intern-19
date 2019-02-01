package com.accolite.carpooling.dao.interfaces;

import java.util.List;

import com.accolite.carpooling.models.User;

public interface UserDao {

	User getUser(int id);

	List<User> getAllUsers();

	boolean createUser(User user);

	boolean updateUser(User user, int userId);

	boolean deleteUser(int id);

	boolean login(String email, String password);

	boolean addUser(User user);

}
