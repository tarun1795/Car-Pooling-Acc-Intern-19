package com.accolite.carpooling.services.interfaces;


import java.util.List;

import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.dto.RideDetailDto;

public interface RideService {
	public List<RideDetailDto> getAllRides(String src,String dest);
	public RideDetailDto getRide(int id);
	public void addRide(Ride ride);
	public void deleteRide(int id);
    public void updateRideSeats(int seats,int id);
}
