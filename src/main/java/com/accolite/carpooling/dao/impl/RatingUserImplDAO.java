package com.accolite.carpooling.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.RatingUserDAO;
import com.accolite.carpooling.models.RatingInsertion;
import com.accolite.carpooling.models.RatingUser;
import com.accolite.carpooling.rowmappers.RatingUserMapper;

@Repository
public class RatingUserImplDAO implements RatingUserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private RatingUser ratingUser;
	
	@Override
	public int getRating(int u_id) {
		ratingUser = (RatingUser) jdbcTemplate.queryForObject(Query.SQL_GET_USER_RATING, new Object[] { u_id }, new RatingUserMapper());
		return ratingUser.getRating();
	}
	
	@Override
	public boolean insertRatingFeedback(int u_id, int rating, String feedback) {
		return jdbcTemplate.update(Query.SQL_INSERT_RATING_DRIEVR, rating, feedback, u_id)>0;
		
	}
}
