package com.accolite.carpooling.services.interfaces;

public interface EmailService {

	public void sendSimpleMessage(String to, String subject, String text);

	//void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
	
}
