package com.accolite.carpooling.models;

public class Vehicle {

	private int vehicleID;
	private String regNo;
	private int userID;
	private int noOfSeats;
	private String name;
	
	public Vehicle() {
		
	}
	public Vehicle(int vehicleID, String regNo, int userID, int noOfSeats, String name) {
		super();
		this.vehicleID = vehicleID;
		this.regNo = regNo;
		this.userID = userID;
		this.noOfSeats = noOfSeats;
		this.name = name;
	}
	
	public int getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
		return "Vehicle [vehicleID=" + vehicleID + ", regNo=" + regNo + ", userID=" + userID + ", noOfSeats="
				+ noOfSeats + ", name=" + name + "]";
	}
	
	
	
}
