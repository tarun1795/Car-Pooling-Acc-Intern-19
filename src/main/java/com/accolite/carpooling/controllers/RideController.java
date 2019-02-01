package com.accolite.carpooling.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.dto.BookingDto;
import com.accolite.carpooling.dto.RideDto;
import com.accolite.carpooling.models.UserRide;
import com.accolite.carpooling.services.interfaces.RideService;
import com.accolite.carpooling.services.interfaces.UserRideService;

/**
 * A controller for the ride related operations
 */
@RestController
@EnableAutoConfiguration
//remove this during final build
@CrossOrigin(origins = "*")
@RequestMapping("ride/")
public class RideController {

	@Autowired
	RideService rideService;

	@Autowired
	UserRideService userRideService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("all")
	public ResponseEntity<List<RideDto>> getRides(@RequestParam("source") String source,
			@RequestParam("destination") String destination) {
		List<RideDto> rides = rideService.getRides(source, destination);
		return new ResponseEntity<>(rides, HttpStatus.OK);
	}

	/**
	 * method is used for sending a ride request to driver
	 */
	@GetMapping(value = "/{rideId}/request/{requestUserId}")
	public ResponseEntity<String> requestForRide(@PathVariable("rideId") int rideId,
			@PathVariable("requestUserId") int requestUserId, @RequestBody int noOfSeatsRequired) {
		try {
			rideService.requestForRide(rideId, requestUserId, noOfSeatsRequired);
			return new ResponseEntity<>("request sent", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("request not sent", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * method is used to respond to request from a rider
	 * 
	 * @param rideId        ride id
	 * @param requestUserId user id of requesting user
	 * @param status        status of request
	 * @return "response sent" if sent correctly else "response not sent"
	 */
	@GetMapping(value = "/{rideId}/response/{requestUserId}/{status}")
	public void responseForRide(@PathVariable("rideId") int rideId, @PathVariable("requestUserId") int requestUserId,
			@PathVariable("status") String status) {

		try {
			rideService.responseForRide(rideId, requestUserId, status);

		} catch (Exception e) {
			e.getCause();
		}

	}


	@GetMapping(value = "/userride/{rideid}/{userid}")
	public ResponseEntity<UserRide> getUserRide(@PathVariable("rideId") int rideId, @PathVariable("userid") int userId) {
		UserRide userRide = userRideService.getUserRide(rideId, userId);
		if (userRide != null)
			return new ResponseEntity<>(userRide, HttpStatus.OK);
		else
			return new ResponseEntity<>(new UserRide(), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/userride/all")
	public ResponseEntity<List<UserRide>> getAllUserRides() {
		List<UserRide> userRides = userRideService.getAllUserRides();

		if (userRides != null)
			return new ResponseEntity<>(userRides, HttpStatus.OK);
		else
			return new ResponseEntity<>(new ArrayList<UserRide>(), HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/bookings/all")
	public ResponseEntity<List<BookingDto>> getAllBookings() {

		List<BookingDto> bookings = rideService.getAllBookings();
		if (bookings != null)
			return new ResponseEntity<>(bookings, HttpStatus.OK);
		else
			return new ResponseEntity<>(new ArrayList<BookingDto>(), HttpStatus.BAD_REQUEST);
	}

}