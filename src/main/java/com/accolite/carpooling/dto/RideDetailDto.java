package com.accolite.carpooling.dto;

import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.models.Vehicle;

/**
 * used for getting Ride and Vehicle associated with the ride
 *
 */
public class RideDetailDto {
	private Vehicle vehicle;
	private Ride ride;

	public RideDetailDto(Vehicle vehicle, Ride ride) {
		super();
		this.vehicle = vehicle;
		this.ride = ride;
	}

	public RideDetailDto() {
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

}