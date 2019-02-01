package com.accolite.carpooling.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.WalletHistoryDao;
import com.accolite.carpooling.models.WalletHistory;
import com.accolite.carpooling.services.interfaces.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	public WalletHistoryDao walletHistoryDao;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public void passwordRecovery(String to, String subject, String text, String link) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText("Hi user\n\n\n" + text + "\n\n\nVisit " + link);
		emailSender.send(message);
	}

	@Override
	public void rideRequest(String to, String subject, String text, String link) {
		passwordRecovery(to,subject,text,link);
	}

	@Override
	public void invoice(String to, String subject, StringBuilder text, int uId) {
		List<WalletHistory> lwh = walletHistoryDao.getAllHistoryDetails(uId);
		text = text.append("\n");
		for (WalletHistory w : lwh) {
			text = text.append(w).append("\n");
		}

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText("Hi user\n\n\n Please find your Invoice" + text + "\n\n\n Thank You \n\n Carpooling");
		emailSender.send(message);
	}

}
