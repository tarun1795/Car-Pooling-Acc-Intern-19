package com.accolite.carpooling.services.impl;

import com.accolite.carpooling.services.interfaces.UserService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.UserDao;
import com.accolite.carpooling.dao.interfaces.VehicleDao;
import com.accolite.carpooling.dto.UserDetailDto;
import com.accolite.carpooling.models.User;
import com.accolite.carpooling.models.Vehicle;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	VehicleDao vehicleDao;

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public UserDetailDto getUserDetail(int id) {
		UserDetailDto userDetails = new UserDetailDto();

		User user = userDao.getUser(id);
		List<Vehicle> vehicles = vehicleDao.getAllVehicles(id);

		userDetails.setUser(user);
		userDetails.setVehicles(vehicles);

		return userDetails;
	}

	@Override
	public boolean updateUserDetail(UserDetailDto userDetails) {
		try {
			User user = userDetails.getUser();
			List<Vehicle> vehicles = userDetails.getVehicles();

			userDao.updateUser(user, user.getUserId());
			for (Vehicle vehicle : vehicles) {
				vehicleDao.updateVehicle(vehicle);
			}

			return true;
		} catch (Exception e) {
			return false;
		}
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