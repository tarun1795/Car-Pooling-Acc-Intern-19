package com.accolite.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.services.interfaces.RideService;


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
	JdbcTemplate jdbcTemplate;

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
	public ResponseEntity<?> responseForRide(@PathVariable("rideId") int rideId,
			@PathVariable("requestUserId") int requestUserId, @PathVariable("status") String status) {

		try {
			rideService.responseForRide(rideId, requestUserId, status);
			return new ResponseEntity<String>("response sent", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("response not sent", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}