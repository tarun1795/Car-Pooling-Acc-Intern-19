package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.RatingUser;

public class RatingUserMapper implements RowMapper<RatingUser> {

	@Override
	public RatingUser mapRow(ResultSet resultSet, int i) throws SQLException {
		RatingUser rs = new RatingUser();
		rs.setRating(resultSet.getInt("avg_rating"));
		return rs;
	}
}
