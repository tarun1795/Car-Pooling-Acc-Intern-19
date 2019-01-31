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

/**
 * 
 * Ride DAO used for ride related queries
 */
@Repository
public class RideDaoImpl implements RideDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	/**
	 * returns all rides matching with src , dest values
	 */
	@Override
	public List<Ride> getAllRides(String src, String dest) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("src", src);
		if (src == null && dest == null)
			return jdbcTemplate.query(Query.GET_ALL_RIDES, new RideMapper());
		if (src == null && dest != null) {
			parameters.addValue("dest", dest);
			return jdbcTemplate.query(Query.GET_ALL_RIDES_TO_DEST, parameters, new RideMapper());
		}
		if (dest == null && src != null) {
			parameters.addValue("src", src);
			return jdbcTemplate.query(Query.GET_ALL_RIDES_FROM_SRC, parameters, new RideMapper());
		}
		parameters.addValue("src", src);
		parameters.addValue("dest", dest);
		return jdbcTemplate.query(Query.GET_ALL_RIDES_FROM_SRC_TO_DEST, parameters, new RideMapper());
	}

	/**
	 * returns a Ride object with ride id = id
	 */
	@Override
	public Ride getRide(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		return jdbcTemplate.queryForObject(Query.GET_RIDE, parameters, new RideMapper());
	}

	/**
	 * used to create a new ride
	 */
	@Override
	public void addRide(Ride ride) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("cost", ride.getCostPerPerson());
		parameters.addValue("source", ride.getSource());
		parameters.addValue("destination", ride.getDestination());
		parameters.addValue("driver_id", ride.getDriverId());
		parameters.addValue("v_id", ride.getVehicleId());
		parameters.addValue("ride_date", ride.getRideDate());
		parameters.addValue("created_date", new Date());
		parameters.addValue("id", ride.getId());
		parameters.addValue("seats_available", ride.getSeatsAvailable());
		jdbcTemplate.update(Query.CREATE_RIDE, parameters);
	}

	/**
	 * used to delete an existing ride
	 */
	@Override
	public void deleteRide(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		jdbcTemplate.update(Query.DELETE_RIDE, parameters);
	}

	/**
	 * used to update no of seats in ride object
	 */
	@Override
	public void updateRideSeats(int seats, int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		System.out.println(id);
		Ride ride = getRide(id);
		System.out.println(ride.getId());
		parameters.addValue("seats", ride.getSeatsAvailable() - seats);
		jdbcTemplate.update(Query.UPDATE_RIDE_SEATS, parameters);
	}

}