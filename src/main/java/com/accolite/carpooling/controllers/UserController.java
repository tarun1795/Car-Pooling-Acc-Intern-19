package com.accolite.carpooling.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

/**
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

	/**
	 * method for getting a single user based on his id
	 * 
	 * @param id user id
	 * @return user if exist else "no user with id found"
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		User user = userService.getUser(id);
		if (user != null)
			return new ResponseEntity<>(user, HttpStatus.OK);
		else
			return new ResponseEntity<>(new User(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * method for getting user and his vehicles together
	 * 
	 * @param id user id
	 * @return user details along with vehicles
	 */
	@GetMapping(value = "/details/{id}")
	public ResponseEntity<UserDetailDto> getUserDetails(@PathVariable("id") int id) {

		try {
			UserDetailDto userDetails = userService.getUserDetail(id);
			return new ResponseEntity<>(userDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new UserDetailDto(), HttpStatus.BAD_REQUEST);

		}
	}

	/**
	 * method for updating user and his vehicles together
	 * 
	 * @param userDetails user details object
	 * @return if found "user details updated" else "user details not found"
	 */
	@PostMapping(value = "/details/{id}")
	public ResponseEntity<String> updateUserDetails(@RequestBody UserDetailDto userDetails) {

		if (userService.updateUserDetail(userDetails))
			return new ResponseEntity<>("user details updated", HttpStatus.OK);
		else
			return new ResponseEntity<>("user details not found", HttpStatus.BAD_REQUEST);

	}

	/**
	 * method is used to get all the users info
	 * 
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/all")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getAllUsers();
		if (users != null)
			return new ResponseEntity<>(users, HttpStatus.OK);
		else
			return new ResponseEntity<>(new ArrayList<User>(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * method is used for updating user based on id
	 * 
	 * @param user   user object
	 * @param userId user id
	 * @return ResponseEntity "user updated" or "user is not updated"
	 */
	@PostMapping(value = "/{id}")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable("id") int userId) {

		if (userService.updateUser(user, userId))
			return new ResponseEntity<>("user updated", HttpStatus.OK);
		else
			return new ResponseEntity<>("user is not updated", HttpStatus.BAD_REQUEST);
	}

	/**
	 * method is used for deleting a user based on his id
	 * 
	 * @param id user id
	 * @return ResponseEntity "user deleted" or "user is not deleted"
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		if (userService.deleteUser(id))
			return new ResponseEntity<>("user deleted", HttpStatus.OK);
		else
			return new ResponseEntity<>("user is not deleted", HttpStatus.BAD_REQUEST);
	}

	/**
	 * method is used to login a user
	 * 
	 * @param user user object
	 * @return ResponseEntity "logged in" or "not logged in"
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@RequestBody LoginDto user) {
		if (userService.login(user.getEmail(), user.getPassword())) {
			return new ResponseEntity<>("logged in", HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>("unable to login", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * method is used to signup a new user
	 * 
	 * @param user user object
	 * @return ResponseEntity "user added" or "user not added"
	 */
	@PostMapping(value = "/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {

		int walletId = jdbcTemplate.queryForObject("select MAX(w_id) from carpooling.wallet", Integer.class);
		walletId++;
		user.setWalletId(walletId);
		if (userService.addUser(user))
			return new ResponseEntity<>("user added", HttpStatus.OK);
		else
			return new ResponseEntity<>("user not added", HttpStatus.BAD_REQUEST);
	}

	/**
	 * method is used to get a vehicle by its id
	 * 
	 * @param id vehicle id
	 * @return ResponseEntity vehicle or "No vehicle with id found"
	 */
	@GetMapping(value = "vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") int id) {
		Vehicle vehicle = vehicleService.getVehicle(id);
		if (vehicle != null)
			return new ResponseEntity<>(vehicle, HttpStatus.OK);
		else
			return new ResponseEntity<>(new Vehicle(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * method is used to get all vehicles related to a particular user
	 * 
	 * @param userId user id
	 * @return ResponseEntity vehicles or "no vehicles found"
	 */
	@GetMapping(value = "vehicle/all/{id}")
	public ResponseEntity<List<Vehicle>> getAllVehicles(@PathVariable("id") int userId) {

		List<Vehicle> vehicles = vehicleService.getAllVehicles(userId);
		if (vehicles != null)
			return new ResponseEntity<>(vehicles, HttpStatus.OK);
		else
			return new ResponseEntity<>(new ArrayList<Vehicle>(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * method is used to create a new vehicle
	 * 
	 * @param vehicle vehicle object
	 * @return "vehicle added or vehicle not added"
	 */
	@PostMapping(value = "vehicle/")
	public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle) {
		if (vehicleService.createVehicle(vehicle))
			return new ResponseEntity<>("vehicle added", HttpStatus.OK);
		else
			return new ResponseEntity<>("vehicle is not added", HttpStatus.BAD_REQUEST);
	}

	/**
	 * method is used to update the vehicle
	 * 
	 * @param vehicle vehicle object
	 * @return
	 */
	@PostMapping(value = "vehicle/{id}")
	public ResponseEntity<String> updateVehicle(@RequestBody Vehicle vehicle) {
		if (vehicleService.updateVehicle(vehicle))
			return new ResponseEntity<>("vehicle updated", HttpStatus.OK);
		else
			return new ResponseEntity<>("vehicle is not updated", HttpStatus.BAD_REQUEST);
	}

	/**
	 * method is used to delete a vehicle
	 * 
	 * @param id vehicle id
	 * @return
	 */
	@DeleteMapping(value = "vehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") int id) {
		if (vehicleService.deleteVehicle(id))
			return new ResponseEntity<>("vehicle deleted", HttpStatus.OK);
		else
			return new ResponseEntity<>("vehicle is not deleted", HttpStatus.BAD_REQUEST);
	}
}