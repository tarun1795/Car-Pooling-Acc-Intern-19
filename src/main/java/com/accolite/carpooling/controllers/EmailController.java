package com.accolite.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.dto.InvoiceDto;
import com.accolite.carpooling.dto.PasswordRecoveryDto;
import com.accolite.carpooling.services.interfaces.EmailService;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

	@Autowired
	EmailService emailService;

	@PostMapping(value = "/passwordrecovery")
	public void passwordRecovery(@RequestBody PasswordRecoveryDto passwordRecovery) {
		emailService.passwordRecovery(passwordRecovery.getToMail(), passwordRecovery.getSubject(),
				passwordRecovery.getText(), passwordRecovery.getLink());
	}

	@PostMapping(value = "/invoice")
	public void invoice(@RequestBody InvoiceDto invoiceDto) {
		emailService.invoice(invoiceDto.getSendTo(), invoiceDto.getSubject(), invoiceDto.getText(),
				invoiceDto.getuId());
	}

}
