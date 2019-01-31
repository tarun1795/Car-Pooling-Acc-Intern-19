package com.accolite.carpooling.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.RideDao;
import com.accolite.carpooling.dao.interfaces.UserDao;
import com.accolite.carpooling.dao.interfaces.UserRideDao;
import com.accolite.carpooling.dao.interfaces.VehicleDao;
import com.accolite.carpooling.dto.RideDetailDto;
import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.models.User;
import com.accolite.carpooling.models.UserRide;
import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.services.interfaces.EmailService;
import com.accolite.carpooling.services.interfaces.RideService;
import com.accolite.carpooling.services.interfaces.WalletService;

@Service
public class RideServiceImpl implements RideService {


	@Autowired
	UserDao userDao;

	@Autowired
	RideDao rideDao;
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	UserRideDao userRideDao;

	@Autowired
	EmailService emailService;
	
	@Autowired
	WalletService walletService;

	@Autowired
	JdbcTemplate jdbcTemplate;
	


	@Override
	public RideDetailDto getRide(int rideId) {
		return null;
	}

	@Override
	public void requestForRide(int rideId, int requestUserId, int noOfSeatsRequired) {

		Ride ride = rideDao.getRide(rideId);
		User user = userDao.getUser(requestUserId);
		User driver = userDao.getUser(ride.getDriverId());
		Vehicle vehicle = vehicleDao.getVehicle(ride.getVehicleId());
		
		
		UserRide userRide = new UserRide(ride.getId(), user.getUserId(), noOfSeatsRequired, "requested", ride.getRideDate(), new Date());

		userRideDao.createUserRide(userRide);

		emailService.rideRequest(driver.getEmail(), "A Request for Carpool",
				"Please click on following link to view the request",
				"http://localhost:8080/ride/" + rideId + "/response/" + requestUserId);

	}

	@Override
	public void responseForRide(int rideId, int requestUserId,String status) {
		User user = userDao.getUser(requestUserId);
		Ride ride = rideDao.getRide(rideId);
		Vehicle vehicle = vehicleDao.getVehicle(ride.getVehicleId());


		if ("accept".equals(status)) {

			User destUser = userDao.getUser(ride.getDriverId()); 
			int costPerPerson = ride.getCostPerPerson();
			walletService.transferMoney(costPerPerson, user.getWalletId(), destUser.getWalletId(), ride.getId(), user.getUserId(), new Date());
			
			UserRide userRide = userRideDao.getUserRide(rideId,requestUserId);
			userRide.setStatus("accepted");
			userRideDao.updateUserRideStatus(userRide);
			
			// TO_DO : change number of seats in 
			rideDao.updateRideSeats(userRide.getNoOfSeats());
			
			emailService.sendSimpleMessage(user.getEmail(), "Carpool Request Status",
					"Your request for carpool has been accepted");

		} else if ("reject".equals(status)) {

			
			UserRide userRide = userRideDao.getUserRide(rideId,requestUserId);
			userRide.setStatus("rejected");
			userRideDao.updateUserRideStatus(userRide);
			
			emailService.sendSimpleMessage(user.getEmail(), "Carpool Request Status",
					"Your request for carpool has been rejected");
 
		}

	}

}
