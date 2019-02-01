package com.accolite.carpooling.controllers;

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
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<?> getRides(@RequestParam("source") String source,
			@RequestParam("destination") String destination) {
		List<RideDto> rides = rideService.getRides(source, destination);
		return new ResponseEntity<List<RideDto>>(rides, HttpStatus.OK);
	}

	/**
	 * method is used for sending a ride request to driver
	 */
	@RequestMapping(value = "/{rideId}/request/{requestUserId}", method = RequestMethod.GET)
	public ResponseEntity<?> requestForRide(@PathVariable("rideId") int rideId,
			@PathVariable("requestUserId") int requestUserId, @RequestBody int noOfSeatsRequired) {
		try {
			rideService.requestForRide(rideId, requestUserId, noOfSeatsRequired);
			return new ResponseEntity<String>("request sent", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("request not sent", HttpStatus.INTERNAL_SERVER_ERROR);
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
	@RequestMapping(value = "/{rideId}/response/{requestUserId}/{status}", method = RequestMethod.GET)
	public void responseForRide(@PathVariable("rideId") int rideId, @PathVariable("requestUserId") int requestUserId,
			@PathVariable("status") String status) {

		try {
			rideService.responseForRide(rideId, requestUserId, status);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// user ride related crud

	@RequestMapping(value = "/userride/{rideid}/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserRide(@PathVariable("rideId") int rideId, @PathVariable("userid") int userId) {
		UserRide userRide = userRideService.getUserRide(rideId, userId);
		if (userRide != null)
			return new ResponseEntity<UserRide>(userRide, HttpStatus.OK);
		else
			return new ResponseEntity<String>("user ride not found", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/userride/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUserRides() {
		List<UserRide> userRides = userRideService.getAllUserRides();

		System.out.println(userRides);
		if (userRides != null)
			return new ResponseEntity<List<UserRide>>(userRides, HttpStatus.OK);
		else
			return new ResponseEntity<String>("no user rides exist", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/bookings/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllBookings() {

		List<BookingDto> bookings = rideService.getAllBookings();
		if (bookings != null)
			return new ResponseEntity<List<BookingDto>>(bookings, HttpStatus.OK);
		else
			return new ResponseEntity<String>("no bookings exist", HttpStatus.BAD_REQUEST);
	}

}