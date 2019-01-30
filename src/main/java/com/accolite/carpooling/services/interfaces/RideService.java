package com.accolite.carpooling.services.interfaces;

import com.accolite.carpooling.dto.RideDetailDto;

public interface RideService {
	public RideDetailDto getRide(int rideId);
	public void requestForRide(int rideId, int requestUserId, int noOfSeatsRequired);
	public void responseForRide(int rideId, int requestUserId, String status);
}
