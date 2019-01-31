package com.accolite.carpooling.services.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.RideDao;
import com.accolite.carpooling.dao.interfaces.VehicleDao;
import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.services.interfaces.RideService;
import com.accolite.carpooling.dto.RideDetailDto;

@Service
public class RideServiceImpl implements RideService{
	
	@Autowired
	private RideDao rideDao;
	
	@Autowired
	private VehicleDao vehicleDao;

	@Override
	public List<RideDetailDto> getAllRides(String src,String dest) {
		 List<Ride> rides = rideDao.getAllRides(src,dest);
		 List<RideDetailDto> rideDetails = new ArrayList<RideDetailDto>();
		 for(Ride ride:rides) {
			 Vehicle vehicle = vehicleDao.getVehicle(ride.getVehicleId());
			 rideDetails.add(new RideDetailDto(vehicle, ride));
		 }
		 return rideDetails;
	}

	@Override
	public RideDetailDto getRide(int id) {
		Ride ride = rideDao.getRide(id);
		Vehicle vehicle = vehicleDao.getVehicle(ride.getVehicleId());
		return new RideDetailDto(vehicle, ride);
	}

	@Override
	public void addRide(Ride ride) {
		rideDao.addRide(ride);
	}

	@Override
	public void deleteRide(int id) {
		rideDao.deleteRide(id);
	}
	
	@Override
	public void updateRideSeats(int seats, int id) {
		rideDao.updateRideSeats(seats,id);
	}
}