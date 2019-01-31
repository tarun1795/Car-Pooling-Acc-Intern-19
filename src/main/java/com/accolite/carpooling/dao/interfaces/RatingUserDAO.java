package com.accolite.carpooling.dao.interfaces;

public interface RatingUserDAO {
	
	public int getRating(int u_id);
	public boolean insertRatingFeedback(int u_id, int rating, String feedback);
	
}
