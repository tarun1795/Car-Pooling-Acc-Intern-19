package com.accolite.carpooling.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accolite.carpooling.dao.interfaces.VehicleDao;
import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.services.impl.VehicleServiceImpl;

public class TestVehicleService {

	@InjectMocks
	VehicleServiceImpl service;

	@Mock
	VehicleDao dao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetVehicle()
	{
		when(dao.getVehicle(1)).thenReturn(new Vehicle(1,"ts 08 er 8218",1,3,"indica"));
		Vehicle vehicle = service.getVehicle(1);
		
		assertEquals(1,vehicle.getVehicleId());
		assertEquals("ts 08 er 8218",vehicle.getRegNo());
		assertEquals(1,vehicle.getUserId());
		assertEquals(3,vehicle.getNoOfSeats());
		assertEquals("indica",vehicle.getName());
	}
	
	
	@Test
	public void testGetAllVehicles()
	{
		List<Vehicle> list = new ArrayList<Vehicle>();
		list.add(new Vehicle(1,"ts 08 er 8218",1,3,"indica"));
		when(dao.getAllVehicles(1)).thenReturn(list);
		
		
		List<Vehicle> vehicleList = service.getAllVehicles(1);
		
		assertEquals(1,vehicleList.get(0).getVehicleId());
		assertEquals("ts 08 er 8218",vehicleList.get(0).getRegNo());
		assertEquals(1,vehicleList.get(0).getUserId());
		assertEquals(3,vehicleList.get(0).getNoOfSeats());
		assertEquals("indica",vehicleList.get(0).getName());
	}
	
	@Test
	public void testCreateVehicle()
	{
		Vehicle vehicle = new Vehicle(1,"ts 08 er 8218",1,3,"indica");
		when(dao.createVehicle(vehicle)).thenReturn(true);
		assertEquals(true,service.createVehicle(vehicle));
		
	}
	
	@Test
	public void testUpdateVehicle()
	{
		Vehicle vehicle = new Vehicle(1,"ts 08 er 8218",1,3,"indica");
		when(dao.updateVehicle(vehicle)).thenReturn(true);
		assertEquals(true,service.updateVehicle(vehicle));
	}
	
	@Test
	public void testDeleteVehicle()
	{
		when(dao.deleteVehicle(1)).thenReturn(true);
		assertEquals(true,service.deleteVehicle(1));
	}
}
