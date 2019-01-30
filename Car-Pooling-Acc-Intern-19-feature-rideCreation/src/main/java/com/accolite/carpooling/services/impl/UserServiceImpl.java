package com.accolite.carpooling.services.impl;

import com.accolite.carpooling.services.interfaces.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.UserDAO;
import com.accolite.carpooling.models.User;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public User getUser(int id) {
		return userDAO.getUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	@Override
	public boolean createUser(User login) {
		return userDAO.createUser(login);
	}

	@Override
	public boolean updateUser(User login, int userId) {
		return userDAO.updateUser(login, userId);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDAO.deleteUser(id);
	}

	@Override
	public boolean login(String email, String password) {
		return userDAO.login(email, password);
	}

	@Override
	public boolean addUser(User user) {		
		return userDAO.addUser(user);
	}
}
