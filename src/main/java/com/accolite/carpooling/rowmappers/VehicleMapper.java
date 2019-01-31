package com.accolite.carpooling.rowmappers;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.Vehicle;

/**
 * row mapper for vehicle
 *
 */
public class VehicleMapper implements RowMapper<Vehicle> {

	public Vehicle mapRow(ResultSet resultSet, int i) throws SQLException {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(resultSet.getInt("v_id"));
		vehicle.setUserId(resultSet.getInt("u_id"));
		vehicle.setRegNo(resultSet.getString("reg_no"));
		vehicle.setName(resultSet.getString("name"));
		vehicle.setNoOfSeats(resultSet.getInt("no_of_seats"));

		return vehicle;
	}
}