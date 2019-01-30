package com.accolite.carpooling.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Ride {
	private String source;
	private String destination;
	private int driverId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date rideDate;
	private int id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private int vehicleId;
	private int costPerPerson;
	
	public Ride() {
		
	}
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public Date getRideDate() {
		return rideDate;
	}
	
	public void setRideDate(Date rideDate) {
		this.rideDate = rideDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public int getCostPerPerson() {
		return costPerPerson;
	}
	public void setCostPerPerson(int costPerPerson) {
		this.costPerPerson = costPerPerson;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
		
}
