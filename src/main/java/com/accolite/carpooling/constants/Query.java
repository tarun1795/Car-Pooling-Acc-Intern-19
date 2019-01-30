package com.accolite.carpooling.constants;

public class Query {
	
	public static final String SQL_GET_VEHICLE_BY_ID = "select v_id,reg_no,u_id,no_of_seats,name from carpooling.vehicle where v_id = ?";
	public static final String SQL_GET_VEHICLES = "select v_id,reg_no,u_id,no_of_seats,name from carpooling.vehicle where u_id = ?";
	public static final String SQL_CREATE_VEHICLE = "insert into vehicle values(?,?,?,?,?)";
	public static final String SQL_UPDATE_VEHICLE = "update vehicle set v_id=?,reg_no=?,u_id=?,no_of_seats=?,name =? where v_id =?";
	public static final String SQL_DELETE_VEHICLE = "delete from vehicle where v_id=?";

	
}
