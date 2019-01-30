//package com.accolite.carpooling.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.accolite.carpooling.models.Vehicle;
//import com.accolite.carpooling.services.interfaces.EmailService;
//import com.accolite.carpooling.services.interfaces.VehicleService;
//
//@RestController
//@EnableAutoConfiguration
////remove this during final build
//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("vehicle/")
//public class VehicleController { 
//
//	
//	@Autowired
//	VehicleService vehicleService;
//	
//	@Autowired
//	EmailService emailService;
//	
//	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
//	public ResponseEntity<?> getVehicle(@PathVariable("id")int id)
//	{
//		Vehicle vehicle = vehicleService.getVehicle(id);
//		if(vehicle != null) 
//			return new ResponseEntity<Vehicle>(vehicle,HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("No vehicle with the id found",HttpStatus.BAD_REQUEST); 
//	}
//	
//	
//	
//	@RequestMapping(value = "/all/{id}", method=RequestMethod.GET)
//	public ResponseEntity<?> getAllVehicles(@PathVariable("id")int userId)
//	{
//		
//		// emailService.sendSimpleMessage("abhinav071197@gmail.com", "test", "hey");
//		List<Vehicle> vehicles = vehicleService.getAllVehicles(userId);
//		if(vehicles != null)
//			return new ResponseEntity<List<Vehicle>>(vehicles,HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("No vehicles found",HttpStatus.BAD_REQUEST); 
//	}
//	
//	
//	@RequestMapping(value = "/", method=RequestMethod.POST)
//	public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle)
//	{
//		if(vehicleService.createVehicle(vehicle))
//			return new ResponseEntity<String>("vehicle added",HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("vehicle is not added",HttpStatus.BAD_REQUEST); 
//	}
//	
//	
//	@RequestMapping(value = "/{id}", method=RequestMethod.POST)
//	public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle)
//	{
//		if(vehicleService.updateVehicle(vehicle))
//			return new ResponseEntity<String>("vehicle updated",HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("vehicle is not updated",HttpStatus.BAD_REQUEST); 
//	}
//	
//	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<?> deleteVehicle(@PathVariable("id")int id)
//	{
//		if(vehicleService.deleteVehicle(id))
//			return new ResponseEntity<String>("vehicle deleted",HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("vehicle is not deleted",HttpStatus.BAD_REQUEST); 
//	}
//}
