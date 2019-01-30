package com.accolite.carpooling.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.VehicleDAO;
import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.services.interfaces.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleDAO vehicleDAO;
	 
	@Override
	public Vehicle getVehicle(int id) {
		return vehicleDAO.getVehicle(id);
	}

	@Override
	public List<Vehicle> getAllVehicles(int userId) {
		return vehicleDAO.getAllVehicles(userId);
	}

	@Override
	public boolean createVehicle(Vehicle vehicle) {
		return vehicleDAO.createVehicle(vehicle);
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		return vehicleDAO.updateVehicle(vehicle);
	}

	@Override
	public boolean deleteVehicle(int id) {
		return vehicleDAO.deleteVehicle(id);
	}

}
