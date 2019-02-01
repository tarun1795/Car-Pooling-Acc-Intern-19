package com.accolite.carpooling.dao.interfaces;

import java.util.List;

import com.accolite.carpooling.dto.BookingDto;
import com.accolite.carpooling.dto.RideDto;
import com.accolite.carpooling.models.Ride;

public interface RideDao {

	public List<RideDto> getRides(String source, String destination);

	public List<Ride> getAllRides(String src, String dest);

	public Ride getRide(int id);

	public void addRide(Ride ride);

	public void deleteRide(int id);

	public void updateRideSeats(int seats, int id);

	public List<BookingDto> getAllBookings();
}