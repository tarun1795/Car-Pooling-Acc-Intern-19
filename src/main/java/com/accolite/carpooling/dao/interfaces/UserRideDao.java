package com.accolite.carpooling.dao.interfaces;

import java.util.List;

import com.accolite.carpooling.models.UserRide;

public interface UserRideDao {

	UserRide getUserRide(int rideId, int userId);

	boolean createUserRide(UserRide userRide);

	boolean updateUserRideStatus(UserRide userRide);

	List<UserRide> getAllUserRides();

}
