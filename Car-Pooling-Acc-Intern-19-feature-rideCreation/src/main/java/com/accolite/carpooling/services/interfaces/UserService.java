package com.accolite.carpooling.services.interfaces;

import java.util.List;


import com.accolite.carpooling.models.User;

public interface UserService {

	User getUser(int id);
	boolean createUser(User login);
	boolean deleteUser(int id);
	boolean updateUser(User user, int userId);
	
	boolean login(String email, String password);
	List<User> getAllUsers();
	boolean addUser(User user);
}
