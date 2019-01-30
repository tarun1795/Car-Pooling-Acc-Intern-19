package com.accolite.carpooling.services.interfaces;

public interface EmailService {

	public void sendSimpleMessage(String to, String subject, String text);

	void rideRequest(String to, String subject, String text, String link);

	void favouriteUserPost(String to, String subject, String text, String link);

	void passwordRecovery(String to, String subject, String text, String link);

	//void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
	
}
