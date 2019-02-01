package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.dto.BookingDto;

public class BookingMapper implements RowMapper<BookingDto> {

	public BookingDto mapRow(ResultSet resultSet, int i) throws SQLException {
		BookingDto bookingDto = new BookingDto();
		bookingDto.setDriverName(resultSet.getString("driver_name"));
		bookingDto.setNoOfSeats(resultSet.getInt("no_of_seats"));
		bookingDto.setRideDate(resultSet.getDate("ride_date"));
		bookingDto.setStatus(resultSet.getString("status"));
		bookingDto.setUserName(resultSet.getString("user_name"));
		return bookingDto;
	}
}
