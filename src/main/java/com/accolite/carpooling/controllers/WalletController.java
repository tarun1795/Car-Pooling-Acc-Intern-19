package com.accolite.carpooling.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.dto.InvoiceDTO;
import com.accolite.carpooling.dto.PassWordRecoveryDTO;
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
	@PostMapping("/passwordrecovery")
	public void passwordRecovery(@RequestBody PassWordRecoveryDTO passwordRecovery) {
		emailService.passwordRecovery(passwordRecovery.getToMail(), passwordRecovery.getSubject(), passwordRecovery.getText(), passwordRecovery.getLink());
	}
	
	/*
	 * Calling Ride Service for sending an email to accept or reject the ride
	 */
	@PostMapping("/rideRequest")
	public void rideRequest() {
		emailService.rideRequest("dileep.matha98@gmail.com", "subject", "text", "link");
	}
	
	/*
	 *  Calling the Email Service for sending the invoice of his transactions to the user
	 */
	@PostMapping("/invoice")
	public void invoice(@RequestBody InvoiceDTO invoiceDTO) {
		emailService.invoice(invoiceDTO.getSendTo(), invoiceDTO.getSubject(), invoiceDTO.getText(), invoiceDTO.getuId());
	}
	
	/*
	 *  Calling the Wallet service for adding money into the wallet 
	 */
	@PostMapping("/addmoney")
	public ResponseEntity<Integer> addmoney(@RequestBody WalletMoney walletmoney) { 
	    Date date = new Date(); 
		Integer amt = walletService.addMoney(walletmoney.getAmt(), walletmoney.getWId(), 1, date);
		return new ResponseEntity<>(amt, HttpStatus.OK);
	}
	
	/*
	 *  Calling the Wallet Service for getting the display the wallet balance
	 */
	@PostMapping("/getmoney")
	public ResponseEntity<Integer> getmoney(@RequestBody WalletMoney walletmoney) {
		Integer amt = walletService.getMoney(walletmoney.getWId());
		return new ResponseEntity<>(amt,HttpStatus.OK);
		
	}
	
	@PostMapping("/transfermoney")
	public void transfer() { 
	    Date date = new Date(); 
		walletService.transferMoney(11, 2, 1, 3, 1, date);
	}
	
	
	/*
	 * Calling the rating service for rating the ride of the user
	 */
	@PostMapping("/ratinguser")
	public void ratinguser(@RequestBody RatingInsertion ratingInsertion) {
		ratingFeedbackService.insertRatingUser(ratingInsertion.getU_id(), ratingInsertion.getRating(), ratingInsertion.getFeedback());
	}
}
