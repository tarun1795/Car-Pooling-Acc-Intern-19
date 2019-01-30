package com.accolite.carpooling.constants;

public class Query {
	public static final String GET_ALL_RIDES = "select * from ride r inner join vehicle v where r.v_id = v.v_id";
	public static final String GET_RIDE = "select * from ride r inner join vehicle v where r.v_id = v.v_id and r_id = :id";
	public static final String CREATE_RIDE = "insert into ride values(:id,:driver_id,:v_id,:source,:destination,:ride_date,:created_date,:cost)";
	public static final String GET_VEHICLE = "select * from vehicle where v_id = ?";
	public static final String GET_ALL_VEHICLES = "select v_id,reg_no,u_id,no_of_seats,name from carpooling.vehicle";
	public static final String CREATE_VEHICLE = "insert into vehicle values(?,?,?,?,?)";
	public static final String UPDATE_VEHICLE = "update vehicle set v_id=?,reg_no=?,u_id=?,no_of_seats=?,name =? where v_id =?";
	public static final String DELETE_VEHICLE = "delete from vehicle where v_id=?";	
}
