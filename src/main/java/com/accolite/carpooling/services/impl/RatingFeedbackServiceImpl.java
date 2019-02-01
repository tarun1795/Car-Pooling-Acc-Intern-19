package com.accolite.carpooling.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.RatingUserDAO;
import com.accolite.carpooling.services.interfaces.RatingFeedbackService;

@Service
public class RatingFeedbackServiceImpl implements RatingFeedbackService {
	
	@Autowired
	RatingUserDAO ratingUserDAO;
	
	@Override
	public int getRatingUser(int uId) {
		return ratingUserDAO.getRating(uId);
	}
	
	/*
	 * 
	 * @see com.accolite.carpooling.services.interfaces.RatingFeedbackService#insertRatingUser(int, int, java.lang.String)
	 */
	
	@Override
	public void insertRatingUser(int uId, int rating, String feedback) {
		ratingUserDAO.insertRatingFeedback(uId, rating, feedback);
	}

}
