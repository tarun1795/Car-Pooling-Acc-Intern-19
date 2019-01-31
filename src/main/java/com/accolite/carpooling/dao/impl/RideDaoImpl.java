package com.accolite.carpooling.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.RideDao;
import com.accolite.carpooling.models.Ride;
import com.accolite.carpooling.rowmappers.RideMapper;

@Repository
public class RideDaoImpl implements RideDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Ride> getAllRides() {
		return jdbcTemplate.query(Query.GET_ALL_RIDES,new RideMapper());
	}

	@Override
	public Ride getRide(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		return jdbcTemplate.queryForObject(Query.GET_RIDE,parameters,new RideMapper());
	}

	@Override
	public boolean addRide(Ride ride) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("cost", ride.getCostPerPerson());
		parameters.addValue("source",ride.getSource());
		parameters.addValue("destination",ride.getDestination());
		parameters.addValue("driver_id",ride.getDriverId());
		parameters.addValue("v_id", ride.getVehicleId());
		parameters.addValue("ride_date", ride.getRideDate());
		parameters.addValue("created_date", new Date());
		parameters.addValue("id",ride.getId());
		jdbcTemplate.update(Query.CREATE_RIDE,parameters);
		return true;
	}

	@Override
	public boolean deleteRide(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateRideSeats(int noOfSeats) {
		// TODO Auto-generated method stub
		
	}

}