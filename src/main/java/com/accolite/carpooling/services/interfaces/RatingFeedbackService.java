package com.accolite.carpooling.services.interfaces;

public interface RatingFeedbackService {

	public int getRatingUser(int uId);
	public void insertRatingUser(int uId, int rating, String s);
}
