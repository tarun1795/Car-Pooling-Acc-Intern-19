package com.accolite.carpooling.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.dto.PassWordRecoveryDTO;
import com.accolite.carpooling.dto.RatingDto;
import com.accolite.carpooling.models.RatingInsertion;
import com.accolite.carpooling.models.WalletMoney;
import com.accolite.carpooling.services.interfaces.EmailService;
import com.accolite.carpooling.services.interfaces.RatingFeedbackService;
import com.accolite.carpooling.services.interfaces.WalletService;

@RestController
@CrossOrigin(origins = "*")
public class WalletController {
	
	@Autowired
	EmailService emailService;
	@Autowired
	WalletService walletService;
	@Autowired
	RatingFeedbackService ratingFeedbackService;
	/*
	 *  Calling Email Service for sending an email to reset password 
	 */
	@RequestMapping(value="/passwordrecovery", method=RequestMethod.POST)
	public void passwordRecovery(@RequestBody PassWordRecoveryDTO passwordRecovery) {
		System.out.println(passwordRecovery.getTo_mail());
		emailService.passwordRecovery(passwordRecovery.getTo_mail(), passwordRecovery.getSubject(), passwordRecovery.getText(), passwordRecovery.getLink());
	}
	
	/*
	 * Calling Ride Service for sending an email to accept or reject the ride
	 */
	@RequestMapping(value="/rideRequest", method=RequestMethod.GET)
	public void rideRequest() {
		emailService.rideRequest("dileep.matha98@gmail.com", "subject", "text", "link");
	}
	
	/*
	 *  Calling the Email Service for sending the invoice of his transactions to the user
	 */
	@RequestMapping(value="/invoice", method=RequestMethod.GET)
	public void invoice() {
		emailService.invoice("dileep.matha98@gmail.com", "Inovice", "Invoice for your Trips in CarPooling");
	}
	
	/*
	 *  Calling the Wallet service for adding money into the wallet 
	 */
	@RequestMapping(value="/addmoney", method=RequestMethod.POST)
	public ResponseEntity<?> addmoney(@RequestBody WalletMoney walletmoney) { 
	    Date date = new Date(); 
		Integer amt = walletService.addMoney(walletmoney.getAmt(), walletmoney.getW_id(), 1, date);
		return new ResponseEntity<Integer>(amt, HttpStatus.OK);
	}
	
	/*
	 *  Calling the Wallet Service for getting the display the wallet balance
	 */
	@RequestMapping(value="/getmoney", method=RequestMethod.POST)
	public ResponseEntity<?> getmoney(@RequestBody WalletMoney walletmoney) {
		Integer amt = walletService.getMoney(walletmoney.getW_id());
		return new ResponseEntity<Integer>(amt,HttpStatus.OK);
		
	}
	
	/*
	@RequestMapping(value="/transfermoney", method=RequestMethod.GET)
	public void transfer() { 
	    Date date = new Date(); 
		walletService.transferMoney(11, 2, 1, 3, 1, date);
	}*/
	
	/*
	 * Calling the rating service for rating the ride of the user
	 */
	@RequestMapping(value="/ratinguser", method=RequestMethod.POST)
	public void ratinguser(@RequestBody RatingInsertion ratingInsertion) {
		System.out.println("rating" + ratingInsertion.getRating());
		ratingFeedbackService.insertRatingUser(ratingInsertion.getU_id(), ratingInsertion.getRating(), ratingInsertion.getFeedback());
	}
}
