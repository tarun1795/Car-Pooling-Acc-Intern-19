package com.accolite.carpooling.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.services.impl.VehicleServiceImpl;

public class TestUserController {

	@InjectMocks
	UserController controller;

	@Mock
	VehicleServiceImpl service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetVehicle() {
		when(service.getVehicle(1)).thenReturn(new Vehicle(1, "ts 08 er 8218", 1, 3, "indica"));
		when(service.getVehicle(2)).thenReturn(null);

		ResponseEntity<Vehicle> vehicle = (ResponseEntity<Vehicle>) controller.getVehicle(1);
		ResponseEntity<Vehicle> vehicle2 = (ResponseEntity<Vehicle>) controller.getVehicle(2);

		assertEquals(1, vehicle.getBody().getVehicleId());
		assertEquals("ts 08 er 8218", vehicle.getBody().getRegNo());
		assertEquals(1, vehicle.getBody().getUserId());
		assertEquals(3, vehicle.getBody().getNoOfSeats());
		assertEquals("indica", vehicle.getBody().getName());

		assertEquals(400, vehicle2.getStatusCodeValue());
	}

	@Test
	public void testGetAllVehicles() {
		List<Vehicle> list = new ArrayList<Vehicle>();
		list.add(new Vehicle(1, "ts 08 er 8218", 1, 3, "indica"));
		when(service.getAllVehicles(1)).thenReturn(list);
		when(service.getAllVehicles(2)).thenReturn(null);

		ResponseEntity<List<Vehicle>> vehicle = (ResponseEntity<List<Vehicle>>) controller.getAllVehicles(1);
		ResponseEntity<List<Vehicle>> vehicle2 = (ResponseEntity<List<Vehicle>>) controller.getAllVehicles(2);

		assertEquals(1, vehicle.getBody().get(0).getVehicleId());
		assertEquals("ts 08 er 8218", vehicle.getBody().get(0).getRegNo());
		assertEquals(1, vehicle.getBody().get(0).getUserId());
		assertEquals(3, vehicle.getBody().get(0).getNoOfSeats());
		assertEquals("indica", vehicle.getBody().get(0).getName());

		assertEquals(400, vehicle2.getStatusCodeValue());
	}

	@Test
	public void testCreateVehicle() {
		Vehicle vehicle = new Vehicle(1, "ts 08 er 8218", 1, 3, "indica");
		Vehicle vehicle2 = new Vehicle(2, "ts 08 er 8218", 1, 3, "indica");
		when(service.createVehicle(vehicle)).thenReturn(true);
		when(service.createVehicle(vehicle2)).thenReturn(false);

		ResponseEntity<String> res1 = (ResponseEntity<String>) controller.createVehicle(vehicle);
		ResponseEntity<String> res2 = (ResponseEntity<String>) controller.createVehicle(vehicle2);

		assertEquals("vehicle added", res1.getBody().toString());
		assertEquals("vehicle is not added", res2.getBody().toString());
	}

	@Test
	public void testUpdateVehicle() {
		Vehicle vehicle = new Vehicle(1, "ts 08 er 8218", 1, 3, "indica");
		Vehicle vehicle2 = new Vehicle(2, "ts 08 er 8218", 1, 3, "indica");
		when(service.updateVehicle(vehicle)).thenReturn(true);
		when(service.updateVehicle(vehicle2)).thenReturn(false);

		ResponseEntity<String> res1 = (ResponseEntity<String>) controller.updateVehicle(vehicle);
		ResponseEntity<String> res2 = (ResponseEntity<String>) controller.updateVehicle(vehicle2);

		assertEquals("vehicle updated", res1.getBody().toString());
		assertEquals("vehicle is not updated", res2.getBody().toString());
	}

	@Test
	public void testDeleteVehicle() {
		when(service.deleteVehicle(1)).thenReturn(true);
		when(service.deleteVehicle(2)).thenReturn(false);

		ResponseEntity<String> res1 = (ResponseEntity<String>) controller.deleteVehicle(1);
		ResponseEntity<String> res2 = (ResponseEntity<String>) controller.deleteVehicle(2);

		assertEquals("vehicle deleted", res1.getBody().toString());
		assertEquals("vehicle is not deleted", res2.getBody().toString());
	}
}
