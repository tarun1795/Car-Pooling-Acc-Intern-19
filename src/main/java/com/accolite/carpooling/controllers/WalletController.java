package com.accolite.carpooling.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.services.interfaces.EmailService;
import com.accolite.carpooling.services.interfaces.RatingFeedbackService;
import com.accolite.carpooling.services.interfaces.WalletService;

@RestController
public class WalletController {
	
	@Autowired
	EmailService emailService;
	@Autowired
	WalletService walletService;
	@Autowired
	RatingFeedbackService ratingFeedbackService;
	
	@RequestMapping(value="/passwordrecovery", method=RequestMethod.GET)
	public void passwordRecovery() {
		emailService.passwordRecovery("dileep.matha98@gmail.com", "subject", "text", "link");
	}
	
	@RequestMapping(value="/rideRequest", method=RequestMethod.GET)
	public void rideRequest() {
		emailService.rideRequest("dileep.matha98@gmail.com", "subject", "text", "link");
	}
	
	@RequestMapping(value="/invoice", method=RequestMethod.GET)
	public void invoice() {
		emailService.invoice("dileep.matha98@gmail.com", "Inovice", "Invoice for your Trips in CarPooling");
	}
	
	@RequestMapping(value="/addmoney", method=RequestMethod.GET)
	public void addmoney() { 
	    Date date = new Date(); 
		walletService.addMoney(120, 1, 1, date);
	}
	
	@RequestMapping(value="/favouriteUser")
	public void favouriteUser() {
		
	}
	@RequestMapping(value="/transfermoney", method=RequestMethod.GET)
	public void transfer() { 
	    Date date = new Date(); 
		walletService.transferMoney(11, 2, 1, 3, 1, date);
	}
	
	@RequestMapping(value="/ratinguser", method=RequestMethod.GET)
	public void ratinguser() {
		System.out.println(ratingFeedbackService.getRatingUser(1));
		
	}
}
