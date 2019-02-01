package com.accolite.carpooling.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.accolite.carpooling.services.impl.RideServiceImpl;

public class TestRideController {

	@InjectMocks
	RideController controller;
	
	@Mock
	RideServiceImpl service;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRequestForRide()
	{
		doThrow(IllegalStateException.class).when(service).requestForRide(5, 2, 1);
		ResponseEntity<String> rideException = (ResponseEntity<String>) controller.requestForRide(5, 2,1);

		
		assertEquals("request not sent",rideException.getBody());

	}

//	@Test
//	public void testResponseForRide()
//	{
//		doThrow(IllegalStateException.class).when(service).responseForRide(5, 2, "rejected");
//		ResponseEntity<String> rideException = (ResponseEntity<String>) controller.responseForRide(5, 2, "rejected");
//		
//
//		
//		assertEquals("response not sent",rideException.getBody());
//	}
	
}
