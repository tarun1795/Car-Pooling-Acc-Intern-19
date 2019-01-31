package com.accolite.carpooling.services.interfaces;

public interface RatingFeedbackService {

	public int getRatingUser(int u_id);
	public void insertRatingUser(int u_id, int rating, String s);
}
