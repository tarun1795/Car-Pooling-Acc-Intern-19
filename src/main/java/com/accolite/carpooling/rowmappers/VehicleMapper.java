package com.accolite.carpooling.rowmappers;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle> {

	public Vehicle mapRow(ResultSet resultSet, int i) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleID(resultSet.getInt("v_id"));
		vehicle.setUserID(resultSet.getInt("u_id"));
		vehicle.setRegNo(resultSet.getString("reg_no"));
		vehicle.setName(resultSet.getString("name"));
		vehicle.setNoOfSeats(resultSet.getInt("no_of_seats"));
		return vehicle;
	}
}