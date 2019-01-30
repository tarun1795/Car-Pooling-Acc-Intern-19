package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.UserRide;

public class UserRideMapper implements RowMapper<UserRide>  {

	@Override
	public UserRide mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRide userRide = new UserRide();
		userRide.setUserId(rs.getInt("u_id"));
		userRide.setRideId(rs.getInt("r_id"));
		userRide.setStatus(rs.getString("status"));
		userRide.setNoOfSeats(rs.getInt("no_of_seats"));
		userRide.setAcceptedTime(rs.getDate("accepted_time"));
		userRide.setRequestedTime(rs.getDate("requested_time"));
		return null;
	}

}
