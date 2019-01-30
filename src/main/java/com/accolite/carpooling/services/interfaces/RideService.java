package com.accolite.carpooling.services.interfaces;


import java.util.List;

import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.dto.RideDetailDto;

public interface RideService {
	public List<RideDetailDto> getAllRides();
	public RideDetailDto getRide(int id);
	public boolean addRide(Ride ride);
	public boolean deleteRide(int id);	
}
