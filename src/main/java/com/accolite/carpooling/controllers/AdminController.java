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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.services.interfaces.RideService;
import com.accolite.carpooling.dto.RideDetailDto;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@EnableAutoConfiguration
@RequestMapping("admin/api/")
public class AdminController {

	@Autowired
	private RideService rideService;

	@GetMapping(value = "/rides")
	public ResponseEntity<List<RideDetailDto>> getAllRides() {
		List<RideDetailDto> rides = rideService.getAllRides();
		if (rides.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RideDetailDto>>(rides, HttpStatus.OK);
	}
	
	@GetMapping(value = "/ride/{id}")
    public ResponseEntity<?> getRide(@PathVariable("id") int id) {
        RideDetailDto ride = rideService.getRide(id);
        if (ride == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RideDetailDto>(ride, HttpStatus.OK);
    }
	
	@PostMapping(value = "/add")
	public boolean addRide(@RequestBody Ride ride) {
		return rideService.addRide(ride);
	}
	
	@DeleteMapping(value = "/del")
	public boolean deleteRide(@PathVariable("id") int id) {
		return rideService.deleteRide(id);
	}
}
