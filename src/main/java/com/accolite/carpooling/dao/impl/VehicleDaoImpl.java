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
			return jdbcTemplate.queryForObject(Query.SQL_GET_VEHICLE_BY_ID, new Object[] { id }, new VehicleMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	} 

	@Override
	public List<Vehicle> getAllVehicles(int userId) {
		return jdbcTemplate.query(Query.SQL_GET_VEHICLES, new Object[] { userId }, new VehicleMapper());
	}
 
	@Override
	public boolean createVehicle(Vehicle vehicle) {
		
		return jdbcTemplate.update(Query.SQL_CREATE_VEHICLE, vehicle.getVehicleId(), vehicle.getRegNo(),
				vehicle.getUserId(), vehicle.getNoOfSeats(), vehicle.getName()) > 0;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		return jdbcTemplate.update(Query.SQL_UPDATE_VEHICLE, vehicle.getVehicleId(), vehicle.getRegNo(),
				vehicle.getUserId(), vehicle.getNoOfSeats(), vehicle.getName(), vehicle.getVehicleId()) > 0;
	}
 
	@Override
	public boolean deleteVehicle(int id) {
		return jdbcTemplate.update(Query.SQL_DELETE_VEHICLE, id) > 0;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return jdbcTemplate.query(Query.GET_ALL_VEHICLES, new VehicleMapper());
	}

}
