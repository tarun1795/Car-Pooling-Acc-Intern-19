package com.accolite.carpooling.dao.interfaces;

import com.accolite.carpooling.models.UserRide;

public interface UserRideDao {

	boolean createUserRide(UserRide userRide);

	boolean updateUserRideStatus(UserRide userRide);

}
