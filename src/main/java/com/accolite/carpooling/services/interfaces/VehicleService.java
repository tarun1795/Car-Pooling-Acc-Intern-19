package com.accolite.carpooling.services.interfaces;

import java.util.List;

import com.accolite.carpooling.models.Vehicle;

/**
 * vehicle related operations can be performed using vehcile service
 *
 */
public interface VehicleService {
	/**
	 * gets a single vehicle
	 * 
	 * @param id vehicle id
	 * @return Vehicle
	 */
	Vehicle getVehicle(int id);

	/**
	 * returns all the vehicles of a particular user
	 * 
	 * @param userId user id
	 * @return vehicles of a user
	 */
	List<Vehicle> getAllVehicles(int userId);

	/**
	 * used to create a new vehicle
	 * 
	 * @param vehicle
	 * @return
	 */
	boolean createVehicle(Vehicle vehicle);

	/**
	 * updates an existing vehicle
	 * 
	 * @param vehicle
	 * @return
	 */
	boolean updateVehicle(Vehicle vehicle);

	/**
	 * deletes an existing vehicle
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteVehicle(int id);
}
