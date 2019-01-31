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
	public int getRatingUser(int u_id) {
		return ratingUserDAO.getRating(u_id);
	}
	
	@Override
	public void insertRatingUser(int u_id, int rating, String feedback) {
		boolean a = ratingUserDAO.insertRatingFeedback(u_id, rating, feedback);
		System.out.println(a);
	}

}
