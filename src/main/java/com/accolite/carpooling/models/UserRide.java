package com.accolite.carpooling.models;

import java.util.Date;


/**
 * userride table object
 *
 */
public class UserRide {

	int rideId;
	int userId;
	int noOfSeats;
	String status;
	Date requestedTime;
	Date acceptedTime;

	public UserRide() {
	}

	public UserRide(int rideId, int userId, int noOfSeats, String status, Date requestedTime, Date acceptedTime) {
		super();
		this.rideId = rideId;
		this.userId = userId;
		this.noOfSeats = noOfSeats;
		this.status = status;
		this.requestedTime = requestedTime;
		this.acceptedTime = acceptedTime;
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRequestedTime() {
		return requestedTime;
	}

	public void setRequestedTime(Date requestedTime) {
		this.requestedTime = requestedTime;
	}

	public Date getAcceptedTime() {
		return acceptedTime;
	}

	public void setAcceptedTime(Date acceptedTime) {
		this.acceptedTime = acceptedTime;
	}

}
