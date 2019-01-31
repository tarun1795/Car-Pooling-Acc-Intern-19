package com.accolite.carpooling.dto;

import java.util.List;

import com.accolite.carpooling.models.*;

public class UserDetailDto {

	User user;
	List<Vehicle> vehicles;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
