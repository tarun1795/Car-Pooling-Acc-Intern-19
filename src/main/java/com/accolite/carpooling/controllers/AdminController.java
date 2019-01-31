package com.accolite.carpooling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.dto.RideDetailDto;
import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.services.interfaces.RideService;

/**
 * Admin Controller provides apis for admin operations
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@EnableAutoConfiguration
@RequestMapping("admin/api/")
public class AdminController {

	@Autowired
	private RideService rideService;

	/**
	 * gets all the rides from src to dest
	 * 
	 * @param src  Source of ride as string
	 * @param dest Destination of ride as String
	 * @return rides if exist else String "no rides found"
	 */
	@GetMapping(value = "/rides")
	public ResponseEntity<?> getAllRides(@RequestParam(value = "src", required = false) String src,
			@RequestParam(value = "dest", required = false) String dest) {
		List<RideDetailDto> rides = rideService.getAllRides(src, dest);
		if (rides.isEmpty()) {
			return new ResponseEntity<String>("no rides found", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RideDetailDto>>(rides, HttpStatus.OK);
	}

	/**
	 * gets the ride object for a specific id
	 * @param id ride id
	 * @return ride if exist else String "ride not found"
	 */
	@GetMapping(value = "/ride/{id}")
	public ResponseEntity<?> getRide(@PathVariable("id") int id) {
		RideDetailDto ride = rideService.getRide(id);
		if (ride == null) {
			return new ResponseEntity<String>("ride not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RideDetailDto>(ride, HttpStatus.OK);
	}

	/**
	 * creates a new Ride in db
	 * @param ride ride object
	 */
	@PostMapping(value = "/add")
	public void addRide(@RequestBody Ride ride) {
		rideService.addRide(ride);
	}

	/**
	 * used to delete an existing ride in db
	 * @param id ride id
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void deleteRide(@PathVariable("id") int id) {
		rideService.deleteRide(id);
	}

	/**
	 * updates the existing ride (no_of_seats) in db
	 * @param seats number of seats to reduce
	 * @param id ride to be updated
	 */
	@PutMapping(value = "/update/{id}")
	public void updateRideSeats(@RequestBody Integer seats, @PathVariable("id") int id) {
		System.out.println(id);
		rideService.updateRideSeats(seats.intValue(), id);
	}
}