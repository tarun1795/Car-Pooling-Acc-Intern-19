package com.accolite.carpooling.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.UserRideDao;
import com.accolite.carpooling.models.UserRide;
import com.accolite.carpooling.rowmappers.UserRideMapper;

@Component
public class UserRideDaoImpl implements UserRideDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Override
	public UserRide getUserRide(int rideId, int userId) {
	
		return jdbcTemplate.queryForObject(Query.SQL_GET_USERRIDE ,new Object[] {rideId, userId}, new UserRideMapper());
	}
	
	@Override
	public boolean createUserRide(UserRide userRide) {
	
		return jdbcTemplate.update(Query.SQL_CREATE_USERRIDE, userRide.getRideId(), userRide.getUserId(),userRide.getStatus()
				,userRide.getNoOfSeats(),userRide.getRequestedTime(),userRide.getAcceptedTime()) > 0;
	}

	@Override
	public boolean updateUserRideStatus(UserRide userRide) {
		return jdbcTemplate.update(Query.SQL_UPDATE_USERRIDE_STATUS, userRide.getStatus(), userRide.getUserId(), userRide.getRideId()) > 0;
	}

	
}
