package com.accolite.carpooling.services.interfaces;

public interface EmailService {

	
	public void sendSimpleMessage(String to, String subject, String text);
	public void passwordRecovery(String to, String subject, String text, String link);
	public void rideRequest(String to, String subject, String text, String link);
	public void invoice(String to, String subject, StringBuilder text, int wId);
	
}
