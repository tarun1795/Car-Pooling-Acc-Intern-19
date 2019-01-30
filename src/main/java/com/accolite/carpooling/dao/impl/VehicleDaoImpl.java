package com.accolite.carpooling.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.VehicleDao;
import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.rowmappers.VehicleMapper;

@Component
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Vehicle getVehicle(int id) {
		try {
			return jdbcTemplate.queryForObject(Query.GET_VEHICLE, new Object[] { id }, new VehicleMapper());
			//return new Vehicle(1, "234", 1, 4, "sai");
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return jdbcTemplate.query(Query.GET_ALL_VEHICLES, new VehicleMapper());
	}

	@Override
	public boolean createVehicle(Vehicle vehicle) {
		return jdbcTemplate.update(Query.CREATE_VEHICLE, vehicle.getVehicleID(), vehicle.getRegNo(),
				vehicle.getUserID(), vehicle.getNoOfSeats(), vehicle.getName()) > 0;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		return jdbcTemplate.update(Query.UPDATE_VEHICLE, vehicle.getVehicleID(), vehicle.getRegNo(),
				vehicle.getUserID(), vehicle.getNoOfSeats(), vehicle.getName(), vehicle.getVehicleID()) > 0;
	}

	@Override
	public boolean deleteVehicle(int id) {
		return jdbcTemplate.update(Query.DELETE_VEHICLE, id) > 0;
	}

}
