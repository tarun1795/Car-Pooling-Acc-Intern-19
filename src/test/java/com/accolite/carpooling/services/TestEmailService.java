package com.accolite.carpooling.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.accolite.carpooling.dao.interfaces.VehicleDao;
import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.services.impl.EmailServiceImpl;
import com.accolite.carpooling.services.impl.VehicleServiceImpl;

public class TestEmailService {

	@InjectMocks
	EmailServiceImpl service;

	@Mock
	JavaMailSender emailSender;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSendSimpleMessege()
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("a@a.com");
		message.setSubject("hi");
		message.setText("hi");
		service.sendSimpleMessage("a@a.com", "hi", "hi");
		verify(emailSender, times(1)).send(message);
		
	}
	
}
