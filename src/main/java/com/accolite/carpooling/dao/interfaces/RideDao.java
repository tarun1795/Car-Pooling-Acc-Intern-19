package com.accolite.carpooling.dao.interfaces;

import java.util.List;

import com.accolite.carpooling.models.Ride;

public interface RideDao {

	Ride getRide(int rideId);

	List<Ride> getAllRides();

	boolean addRide(Ride ride);

	boolean deleteRide(int id);

}
