package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.accolite.carpooling.models.Ride;

/**
 * row mapper for Ride
 *
 */
public class RideMapper implements RowMapper<Ride>{
	
	public Ride mapRow(ResultSet rs,int i) throws SQLException {
		Ride ride = new Ride();
		ride.setCostPerPerson(rs.getInt("cost_per_person"));
		ride.setCreatedDate(rs.getDate("created_date"));
		ride.setDestination(rs.getString("destination"));
		ride.setDriverId(rs.getInt("driver_id"));
		ride.setSource(rs.getString("source"));
		ride.setRideDate(rs.getDate("ride_date"));
		ride.setVehicleId(rs.getInt("v_id"));
		ride.setId(rs.getInt("r_id"));
		ride.setSeatsAvailable(rs.getInt("seats_available"));
		return ride;
	}
	
}