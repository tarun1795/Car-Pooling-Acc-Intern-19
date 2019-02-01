package com.accolite.carpooling.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.models.WalletMoney;
import com.accolite.carpooling.services.interfaces.WalletService;

@RestController
@CrossOrigin(origins = "*")
public class WalletController {
	
	@Autowired
	WalletService walletService;
	
	@PostMapping(value="/getmoney")
	public ResponseEntity<Integer> getmoney(@RequestBody WalletMoney walletmoney) {
		Integer amt = walletService.getMoney(walletmoney.getwId());
		return new ResponseEntity<>(amt,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/addmoney")
	public ResponseEntity<Integer> addmoney(@RequestBody WalletMoney walletmoney) { 
	    Date date = new Date(); 
		Integer amt = walletService.addMoney(walletmoney.getAmt(), walletmoney.getwId(), 1, date);
		return new ResponseEntity<>(amt, HttpStatus.OK);
	}
}
