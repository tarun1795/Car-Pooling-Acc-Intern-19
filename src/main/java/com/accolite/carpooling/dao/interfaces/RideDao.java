package com.accolite.carpooling.dao.interfaces;

import java.util.List;

import com.accolite.carpooling.models.Ride;

public interface RideDao {
	
	public List<Ride> getAllRides();
	public Ride getRide(int id);
	public boolean addRide(Ride ride);
	public boolean deleteRide(int id);
	
}
