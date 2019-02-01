package com.accolite.carpooling.services.interfaces;

import java.util.List;
import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.dto.BookingDto;
import com.accolite.carpooling.dto.RideDetailDto;
import com.accolite.carpooling.dto.RideDto;

/**
 * Ride related operations can be done using RideService 
 *
 */
public interface RideService {
	/**
	 * lists all rides 
	 * @param src Source
	 * @param dest Destination
	 * @return return list of matching rides
	 */
	
	public List<RideDto> getRides(String source, String destination);
	
	/**
	 * lists all rides from src to dest
	 * @param src Source
	 * @param dest Destination
	 * @return return list of matching rides
	 */
	public List<RideDetailDto> getAllRides(String src, String dest);

	/**
	 * gets a specific ride
	 * @param id ride id
	 * @return returns the RideDetails
	 */
	public RideDetailDto getRide(int id);

	/**
	 * creates a new Ride
	 * @param ride Ride object
	 */
	public void addRide(Ride ride);

	/**
	 * deltes an existing ride
	 * @param id ride id
	 */
	public void deleteRide(int id);

	/**
	 * updates no_of_Seats in ride
	 * @param seats no of seats
	 * @param id ride id
	 */
	public void updateRideSeats(int seats, int id);

	/**
	 * sends a request to join the ride
	 * @param rideId ride id
	 * @param requestUserId user id
	 * @param noOfSeatsRequired no of seats required
	 */
	void requestForRide(int rideId, int requestUserId, int noOfSeatsRequired);

	/**
	 * sends a response for a ride request
	 * @param rideId ride id
	 * @param requestUserId user id
	 * @param status status (accepted,rejected,pending)
	 */
	void responseForRide(int rideId, int requestUserId, String status);
	
	
	List<BookingDto> getAllBookings();
}