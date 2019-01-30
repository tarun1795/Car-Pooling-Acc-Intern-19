package com.accolite.carpooling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.dto.RideDto;
import com.accolite.carpooling.services.interfaces.RideService;

@RestController
@RequestMapping("ride")
public class RideController {
	@Autowired
	RideService rideService;
	@GetMapping("all")
	public ResponseEntity<?> getRides(@RequestParam("source") String source,@RequestParam("destination") String destination){
		List<RideDto> rides=rideService.getRides(source, destination);
		return new ResponseEntity<List<RideDto>>(rides,HttpStatus.OK);
	}
}
