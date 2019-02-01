package com.accolite.carpooling.dao.interfaces;

public interface RatingUserDAO {
	
	public int getRating(int uId);
	public boolean insertRatingFeedback(int uId, int rating, String feedback);
	
}
