package com.accolite.carpooling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.dto.LoginDto;
import com.accolite.carpooling.models.User;
import com.accolite.carpooling.services.interfaces.UserService;

@RestController
@EnableAutoConfiguration	
//remove this during final build
@CrossOrigin(origins = "*")
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") int id) {
		User user = userService.getUser(id);
		if (user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else
			return new ResponseEntity<String>("No user with the id found", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ResponseEntity<?> getUsers() {
		List<User> users = userService.getAllUsers();
		if (users != null)
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		else
			return new ResponseEntity<String>("No users found", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") int userId) {

		if (userService.updateUser(user, userId))
			return new ResponseEntity<String>("user updated", HttpStatus.OK);
		else
			return new ResponseEntity<String>("user is not updated", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		if (userService.deleteUser(id))
			return new ResponseEntity<String>("user deleted", HttpStatus.OK);
		else
			return new ResponseEntity<String>("user is not deleted", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "login", method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginDto user)
	{
		if(userService.login(user.getEmail(), user.getPassword()))
				{
			return new ResponseEntity<String>("logged in", HttpStatus.OK);
				}
		else
			return new ResponseEntity<String>("unable to login", HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseEntity<?> signup(@RequestBody User user){
		if (userService.addUser(user))
			return new ResponseEntity<String>("user added", HttpStatus.OK);
		else
			return new ResponseEntity<String>("user not added", HttpStatus.BAD_REQUEST);
	}		
}
	



