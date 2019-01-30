package com.accolite.carpooling.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.models.Vehicle;
import com.accolite.carpooling.rowmappers.VehicleMapper;

public class TestVehicleDAO {

	private static JdbcTemplate jdbcTemplate;
	
	@BeforeClass
	public static  void setup() {
		EmbeddedDatabase db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("cmd.sql").build();
		
		jdbcTemplate = new JdbcTemplate(db);

	}
	
	@Test
	public void testGetVehicle() {
	
		Vehicle vehicle = jdbcTemplate.queryForObject(Query.SQL_GET_VEHICLE_BY_ID, new Object[] { 1 }, new VehicleMapper());
		assertEquals("TS 08 ER 1111",vehicle.getRegNo());
		assertEquals("Tata Indica",vehicle.getName());
		assertEquals(4,vehicle.getNoOfSeats());
		assertEquals(1,vehicle.getUserId());
		
	}
	
	
	@Test
	public void testGetAllVehicles() {
	
		List<Vehicle> vehicles = jdbcTemplate.query(Query.SQL_GET_VEHICLES, new Object[] { 1 }, new VehicleMapper());
		assertEquals("TS 08 ER 1111",vehicles.get(0).getRegNo());
		assertEquals("Tata Indica",vehicles.get(0).getName());
		assertEquals(4,vehicles.get(0).getNoOfSeats());
		assertEquals(1,vehicles.get(0).getUserId());
		
	}
	
	@Test
	public void testCreateVehicle() {
	
		
//		Vehicle vehicle = new Vehicle(5, "TS 08 ER 1111", 1, 4, "Tata Indica");
//		jdbcTemplate.update(Query.SQL_CREATE_VEHICLE, vehicle.getVehicleId(), vehicle.getRegNo(),
//				vehicle.getUserId(), vehicle.getNoOfSeats(), vehicle.getName());
//		
//		Vehicle queriedVehicle = jdbcTemplate.queryForObject(Query.SQL_GET_VEHICLE_BY_ID, new Object[] { 5 }, new VehicleMapper());
//
//		assertEquals("TS 08 ER 1111",queriedVehicle.getRegNo());
//		assertEquals("Tata Indica",queriedVehicle.getName());
//		assertEquals(4,queriedVehicle.getNoOfSeats());
//		assertEquals(1,queriedVehicle.getUserId());
		
	}
	
	

}
