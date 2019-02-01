package com.accolite.carpooling.dto;

public class RideDto {
	
	String rideId;
	String driverId;
	String driverName;
	String driverEmail;
	String driverPhoneno;
	String vehicleNumber;
	String vehicleName;
	int seatsAvailable;
	int costPerSeat;
	String createdTime;
	public String getRideId() {
		return rideId;
	}
	public void setRideId(String rideId) {
		this.rideId = rideId;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverEmail() {
		return driverEmail;
	}
	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}
	public String getDriverPhoneno() {
		return driverPhoneno;
	}
	public void setDriverPhoneno(String driverPhoneno) {
		this.driverPhoneno = driverPhoneno;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public int getCostPerSeat() {
		return costPerSeat;
	}
	public void setCostPerSeat(int costPerSeat) {
		this.costPerSeat = costPerSeat;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
}