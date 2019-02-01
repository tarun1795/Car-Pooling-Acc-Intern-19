package com.accolite.carpooling.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.RideDao;
import com.accolite.carpooling.dao.interfaces.UserRideDao;
import com.accolite.carpooling.dto.BookingDto;
import com.accolite.carpooling.models.UserRide;
import com.accolite.carpooling.services.interfaces.UserRideService;

@Service
public class UserRideServiceImpl implements UserRideService {

	@Autowired
	UserRideDao userRideDao;
	
	@Autowired
	RideDao rideDao;

	@Override
	public UserRide getUserRide(int rideId, int userId) {
		return userRideDao.getUserRide(rideId, userId);
	}

	@Override
	public List<UserRide> getAllUserRides() {
		return userRideDao.getAllUserRides();
	}

	@Override
	public boolean createUserRide(UserRide userRide) {
		return userRideDao.createUserRide(userRide);
	}

	@Override
	public boolean updateUserRide(UserRide userRide) {
		return userRideDao.updateUserRideStatus(userRide);
	}

	@Override
	public List<BookingDto> getAllBookings() {
		return rideDao.getAllBookings();
	}
}
