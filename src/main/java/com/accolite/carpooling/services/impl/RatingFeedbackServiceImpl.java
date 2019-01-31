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

}
