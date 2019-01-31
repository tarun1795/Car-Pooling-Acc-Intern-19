package com.accolite.carpooling.services.impl;

import com.accolite.carpooling.services.interfaces.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.UserDao;
import com.accolite.carpooling.models.User;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Override
	public boolean createUser(User login) {
		return userDao.createUser(login);
	}

	@Override
	public boolean updateUser(User login, int userId) {
		return userDao.updateUser(login, userId);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public boolean login(String email, String password) {
		return userDao.login(email, password);
	}

	@Override
	public boolean addUser(User user) {		
		return userDao.addUser(user);
	}
}