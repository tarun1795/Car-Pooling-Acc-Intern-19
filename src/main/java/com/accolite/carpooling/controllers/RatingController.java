package com.accolite.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.carpooling.models.RatingInsertion;
import com.accolite.carpooling.services.interfaces.RatingFeedbackService;


@RestController
@CrossOrigin(origins = "*")
public class RatingController {

	@Autowired
	RatingFeedbackService ratingFeedbackService;
	
	
	@PostMapping(value="/ratinguser")
	public void ratinguser(@RequestBody RatingInsertion ratingInsertion) {
		ratingFeedbackService.insertRatingUser(ratingInsertion.getuId(), ratingInsertion.getRating(), ratingInsertion.getFeedback());
	}
}
