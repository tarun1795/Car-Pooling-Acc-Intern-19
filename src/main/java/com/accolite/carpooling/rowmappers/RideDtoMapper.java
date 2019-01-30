package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.dto.RideDto;

public class RideDtoMapper implements RowMapper<RideDto> {

	@Override
	public RideDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		RideDto rideDto=new RideDto();
		rideDto.setRideId(rs.getString(1));
		rideDto.setSeatsAvailable(Integer.parseInt(rs.getString(2)));
		rideDto.setCostPerSeat(Integer.parseInt(rs.getString(3)));
		rideDto.setCreatedTime(rs.getString(4));
		rideDto.setDriverName(rs.getString(5));
		rideDto.setDriverEmail(rs.getString(6));
		rideDto.setVehicleName(rs.getString(7));
		rideDto.setVehicleNumber(rs.getString(8));
		return rideDto;
	}

}
