package com.accolite.carpooling.dao.interfaces;

import java.util.List;
import com.accolite.carpooling.models.Vehicle;

public interface VehicleDao {
	
	Vehicle getVehicle(int id);
	
	List<Vehicle> getAllVehicles(int userId);
	
	boolean createVehicle(Vehicle vehicle);
	
	boolean updateVehicle(Vehicle vehicle);
	
	boolean deleteVehicle(int id);

}
