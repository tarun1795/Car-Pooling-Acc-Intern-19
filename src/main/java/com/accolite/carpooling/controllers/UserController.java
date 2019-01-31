package com.accolite.carpooling.controllers;

import java.util.List;

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

import com.accolite.carpooling.dto.LoginDto;
import com.accolite.carpooling.dto.UserDetailDto;
import com.accolite.carpooling.models.User;
import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.services.interfaces.EmailService;
import com.accolite.carpooling.services.interfaces.UserService;
import com.accolite.carpooling.services.interfaces.VehicleService;

/*
 * A controller for User related operations
 */
@RestController
@EnableAutoConfiguration
//remove this during final build
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	VehicleService vehicleService;

	@Autowired
	EmailService emailService;

	@Autowired
	UserService userService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * method for getting a single user based on his id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") int id) {
		User user = userService.getUser(id);
		if (user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<String>("No user with the id found", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method for getting user and his vehicles together
	 */
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserDetails(@PathVariable("id") int id) {

		try {
			UserDetailDto userDetails = userService.getUserDetail(id);
			return new ResponseEntity<UserDetailDto>(userDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("user details not found", HttpStatus.BAD_REQUEST);

		}
	}

	/*
	 * method for updating user and his vehicles together
	 */
	@RequestMapping(value = "/details/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> updateUserDetails(@RequestBody UserDetailDto userDetails) {

		if (userService.updateUserDetail(userDetails))
			return new ResponseEntity<String>("user details updated", HttpStatus.OK);
		else
			return new ResponseEntity<String>("user details not found", HttpStatus.BAD_REQUEST);

	}

	

	/*
	 * method is used to get all the users info
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		List<User> users = userService.getAllUsers();
		if (users != null)
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		else
			return new ResponseEntity<String>("No users found", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used for updating user based on id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") int userId) {

		if (userService.updateUser(user, userId))
			return new ResponseEntity<String>("user updated", HttpStatus.OK);
		else
			return new ResponseEntity<String>("user is not updated", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used for deleting a user based on his id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		if (userService.deleteUser(id))
			return new ResponseEntity<String>("user deleted", HttpStatus.OK);
		else
			return new ResponseEntity<String>("user is not deleted", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used to login a user
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginDto user) {
		if (userService.login(user.getEmail(), user.getPassword())) {
			return new ResponseEntity<String>("logged in", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("unable to login", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used to signup a new user
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> signup(@RequestBody User user) {
		
		int walletId = jdbcTemplate.queryForObject("select MAX(w_id)+1 from carpooling.wallet", Integer.class);
		user.setWalletId(walletId);
		if (userService.addUser(user))
			return new ResponseEntity<String>("user added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("user not added", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used to get a vehicle by its id
	 */
	@RequestMapping(value = "vehicle/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getVehicle(@PathVariable("id") int id) {
		Vehicle vehicle = vehicleService.getVehicle(id);
		if (vehicle != null)
			return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
		else
			return new ResponseEntity<String>("No vehicle with the id found", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used to get all vehicles related to a particular user
	 */
	@RequestMapping(value = "vehicle/all/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllVehicles(@PathVariable("id") int userId) {

		List<Vehicle> vehicles = vehicleService.getAllVehicles(userId);
		if (vehicles != null)
			return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
		else
			return new ResponseEntity<String>("No vehicles found", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used to create a new vehicle
	 */
	@RequestMapping(value = "vehicle/", method = RequestMethod.POST)
	public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle) {
		if (vehicleService.createVehicle(vehicle))
			return new ResponseEntity<String>("vehicle added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("vehicle is not added", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used to update the vehicle
	 */
	@RequestMapping(value = "vehicle/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) {
		if (vehicleService.updateVehicle(vehicle))
			return new ResponseEntity<String>("vehicle updated", HttpStatus.OK);
		else
			return new ResponseEntity<String>("vehicle is not updated", HttpStatus.BAD_REQUEST);
	}

	/*
	 * method is used to delete a vehicle
	 */
	@RequestMapping(value = "vehicle/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteVehicle(@PathVariable("id") int id) {
		if (vehicleService.deleteVehicle(id))
			return new ResponseEntity<String>("vehicle deleted", HttpStatus.OK);
		else
			return new ResponseEntity<String>("vehicle is not deleted", HttpStatus.BAD_REQUEST);
	}
}