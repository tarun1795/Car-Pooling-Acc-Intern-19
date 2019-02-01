package com.accolite.carpooling.services.interfaces;

/**
 * Email Related operations can be performed using EmailService
 *
 */
public interface EmailService {

	/**
	 * sends a simple mail
	 * 
	 * @param to      receiver email address
	 * @param subject subject of mail
	 * @param text    body of mail
	 */
	public void sendSimpleMessage(String to, String subject, String text);

	/**
	 * sends a simple mail
	 * 
	 * @param to      receiver email address
	 * @param subject subject of mail
	 * @param text    body of mail
	 * @param link    url to be included
	 */
	public void rideRequest(String to, String subject, String text, String link);

	/**
	 * sends a password recovery mail
	 * 
	 * @param to      receiver email address
	 * @param subject subject of mail
	 * @param text    body of mail
	 * @param link    url to be included
	 */
	public void passwordRecovery(String to, String subject, String text, String link);

	/**
	 * sends a mail with invoice
	 * 
	 * @param to      receiver email address
	 * @param subject subject of mail
	 * @param text    body of mail
	 */
	public void invoice(String to, String subject, StringBuilder text, int uId);

}
