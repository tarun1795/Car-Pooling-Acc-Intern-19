package com.accolite.carpooling.constants;

public class Query {
	
	public static final String SQL_GET_VEHICLE_BY_ID = "select v_id,reg_no,u_id,no_of_seats,name from carpooling.vehicle where v_id = ?";
	public static final String SQL_GET_VEHICLES = "select v_id,reg_no,u_id,no_of_seats,name from carpooling.vehicle where u_id = ?";
	public static final String SQL_CREATE_VEHICLE = "insert into vehicle values(?,?,?,?,?)";
	public static final String SQL_UPDATE_VEHICLE = "update vehicle set v_id=?,reg_no=?,u_id=?,no_of_seats=?,name =? where v_id =?";
	public static final String SQL_DELETE_VEHICLE = "delete from vehicle where v_id=?";
	public static final String SQL_SELECT_RIDE_JOIN_USER_JOIN_VEHICLE="select r.r_id,r.seats_available,r.cost_per_person,r.created_date,"
																	+ "driver.name,driver.email,v.name,v.reg_no from ride as r, user as driver,"
																	+ "vehicle as v where r.driver_id=driver.u_id and r.v_id=v.v_id";
	
}
