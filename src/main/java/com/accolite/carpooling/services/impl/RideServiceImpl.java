package com.accolite.carpooling.services.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.RideDao;
import com.accolite.carpooling.dao.interfaces.UserDao;
import com.accolite.carpooling.dao.interfaces.UserRideDao;
import com.accolite.carpooling.dao.interfaces.VehicleDao;
import com.accolite.carpooling.dto.BookingDto;
import com.accolite.carpooling.dto.RideDetailDto;
import com.accolite.carpooling.dto.RideDto;
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
	public List<RideDto> getRides(String source, String destination) {
		return rideDao.getRides(source, destination);
	}

	@Override
	public List<RideDetailDto> getAllRides(String src, String dest) {
		List<Ride> rides = rideDao.getAllRides(src, dest);
		List<RideDetailDto> rideDetails = new ArrayList<RideDetailDto>();
		for (Ride ride : rides) {
			Vehicle vehicle = vehicleDao.getVehicle(ride.getVehicleId());
			rideDetails.add(new RideDetailDto(vehicle, ride));
		}
		return rideDetails;
	}

	@Override
	public RideDetailDto getRide(int id) {
		Ride ride = rideDao.getRide(id);
		Vehicle vehicle = vehicleDao.getVehicle(ride.getVehicleId());
		return new RideDetailDto(vehicle, ride);
	}

	@Override
	public void addRide(Ride ride) {
		rideDao.addRide(ride);
	}

	@Override
	public void deleteRide(int id) {
		rideDao.deleteRide(id);
	}

	@Override
	public void updateRideSeats(int seats, int id) {
		rideDao.updateRideSeats(seats, id);
	}

	@Override
	public void requestForRide(int rideId, int requestUserId, int noOfSeatsRequired) {

		Ride ride = rideDao.getRide(rideId);
		User user = userDao.getUser(requestUserId);
		User driver = userDao.getUser(ride.getDriverId());

		UserRide userRide = new UserRide(ride.getId(), user.getUserId(), noOfSeatsRequired, "requested",
				ride.getRideDate(), new Date());

		userRideDao.createUserRide(userRide);

		emailService.rideRequest(driver.getEmail(), "A Request for Carpool",
				"Please click on following link to view the request",
				"http://localhost:8080/ride/" + rideId + "/response/" + requestUserId);

	}

	@Override
	public void responseForRide(int rideId, int requestUserId, String status) {

		System.out.println(rideId + " " + requestUserId + " " + status);
		User user = userDao.getUser(requestUserId);
		Ride ride = rideDao.getRide(rideId);

		try {

			if ("accept".equals(status)) {

				User destUser = userDao.getUser(ride.getDriverId());
				int costPerPerson = ride.getCostPerPerson();
				walletService.transferMoney(costPerPerson, user.getWalletId(), destUser.getWalletId(), ride.getId(),
						user.getUserId(), new Date());

				UserRide userRide = userRideDao.getUserRide(rideId, requestUserId);
				userRide.setStatus("accepted");
				userRideDao.updateUserRideStatus(userRide);

				// TO_DO : change number of seats in
				rideDao.updateRideSeats(userRide.getNoOfSeats(), userRide.getRideId());

				emailService.sendSimpleMessage(user.getEmail(), "Carpool Request Status",
						"Your request for carpool has been accepted");

			} else if ("reject".equals(status)) {

				UserRide userRide = userRideDao.getUserRide(rideId, requestUserId);
				userRide.setStatus("rejected");
				userRideDao.updateUserRideStatus(userRide);

				emailService.sendSimpleMessage(user.getEmail(), "Carpool Request Status",
						"Your request for carpool has been rejected");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<BookingDto> getAllBookings() {
		return rideDao.getAllBookings();
	}

}
