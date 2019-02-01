package com.accolite.carpooling.services.interfaces;

import java.util.List;

import com.accolite.carpooling.dto.BookingDto;
import com.accolite.carpooling.models.UserRide;

public interface UserRideService {

	UserRide getUserRide(int rideId, int userId);
	
	List<UserRide> getAllUserRides();
	
	boolean createUserRide(UserRide userRide);
	
	boolean updateUserRide(UserRide userRide);
	
	List<BookingDto> getAllBookings();
	
}
