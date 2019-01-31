package com.accolite.carpooling.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.UserRideDao;
import com.accolite.carpooling.models.UserRide;
import com.accolite.carpooling.rowmappers.UserRideMapper;

/**
 * UserRide DAO is used for UserRide related queries
 *
 */
@Component
public class UserRideDaoImpl implements UserRideDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * used to get a UserRide object based on rideId and userId
	 */
	@Override
	public UserRide getUserRide(int rideId, int userId) {
	
		return jdbcTemplate.queryForObject(Query.SQL_GET_USERRIDE ,new Object[] {rideId, userId}, new UserRideMapper());
	}
	
	/**
	 * used to create an entry into the userride table
	 */
	@Override
	public boolean createUserRide(UserRide userRide) {
	
		return jdbcTemplate.update(Query.SQL_CREATE_USERRIDE, userRide.getRideId(), userRide.getUserId(),userRide.getStatus()
				,userRide.getNoOfSeats(),userRide.getRequestedTime(),userRide.getAcceptedTime()) > 0;
	}

	/**
	 * used to update existing userRide entry
	 */
	@Override
	public boolean updateUserRideStatus(UserRide userRide) {
		return jdbcTemplate.update(Query.SQL_UPDATE_USERRIDE_STATUS, userRide.getStatus(), userRide.getUserId(), userRide.getRideId()) > 0;
	}

	
}
