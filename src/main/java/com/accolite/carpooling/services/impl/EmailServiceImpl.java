package com.accolite.carpooling.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.WalletHistoryDAO;
import com.accolite.carpooling.models.WalletHistory;
import com.accolite.carpooling.services.interfaces.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	public JavaMailSender emailSender;
	@Autowired
	WalletHistoryDAO walletHistoryDAO;
	
	/*
	 * (non-Javadoc)
	 * @see com.accolite.carpooling.services.interfaces.EmailService#sendSimpleMessage(java.lang.String, java.lang.String, java.lang.String)
	 */
	
	@Override
	public void sendSimpleMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accolite.carpooling.services.interfaces.EmailService#passwordRecovery(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void passwordRecovery(String to, String subject, String text, String link) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText("Hi user\n\n\n" + text +"\n\n\nVisit "+link);
		emailSender.send(message);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accolite.carpooling.services.interfaces.EmailService#rideRequest(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void rideRequest(String to, String subject, String text, String link){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText("Hi user\n\n\n" + text +"\n\n\nVisit "+link);
		emailSender.send(message);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accolite.carpooling.services.interfaces.EmailService#invoice(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void invoice(String to, String subject, String text){
		List<WalletHistory> lwh = walletHistoryDAO.getAllHistoryDetails();
		text = text + "\n";
		for(WalletHistory w : lwh) {
			text = text + w + "\n";
		}
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText("Hi user\n\n\n Please find your Invoice" + text +"\n\n\n Thank You \n\n Carpooling");
		emailSender.send(message);
	}
}
