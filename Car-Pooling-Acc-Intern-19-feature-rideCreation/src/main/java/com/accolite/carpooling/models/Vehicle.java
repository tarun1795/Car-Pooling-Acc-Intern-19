package com.accolite.carpooling.models;

public class Vehicle {

	private int vehicleId;
	private String regNo;
	private int userId;
	private int noOfSeats;
	private String name;
	
	
	
	
	public Vehicle() {
		super();
	}


	public Vehicle(int vehicleId, String regNo, int userId, int noOfSeats, String name) {
		super();
		this.vehicleId = vehicleId;
		this.regNo = regNo;
		this.userId = userId;
		this.noOfSeats = noOfSeats;
		this.name = name;
	}
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleId + ", regNo=" + regNo + ", userID=" + userId + ", noOfSeats="
				+ noOfSeats + ", name=" + name + "]";
	}
	
	
	
}
