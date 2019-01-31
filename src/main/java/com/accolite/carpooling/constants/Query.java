package com.accolite.carpooling.constants;

/*
 * A Holder for all the query constants
 */
public class Query {
	
	/*
	 *  vehicle related queries
	 */
	public static final String SQL_GET_VEHICLE_BY_ID = "select v_id,reg_no,u_id,no_of_seats,name from carpooling.vehicle where v_id = ?";
	public static final String SQL_GET_VEHICLES = "select v_id,reg_no,u_id,no_of_seats,name from carpooling.vehicle where u_id = ?";
	public static final String SQL_CREATE_VEHICLE = "insert into vehicle values(?,?,?,?,?)";
	public static final String SQL_UPDATE_VEHICLE = "update vehicle set v_id=?,reg_no=?,u_id=?,no_of_seats=?,name =? where v_id =?";
	public static final String SQL_DELETE_VEHICLE = "delete from vehicle where v_id=?";

	
	/*
	 *  ride request related queries
	 */
	public static final String SQL_UPDATE_RIDE_NO_OF_SEATS = "update ride set seats_available = ? where r_id = ?";

	
	/*
	 * wallet related queries
	 */
	public static final String SQL_ADD_MONEY = "update wallet set amount = ? where w_id = ? ";
	public static final String SQL_TRANSFER_MONEY = "update wallet set amount = ? where w_id = ?";
	public static final String SQL_TRANSFER_MONEY_HISTORY = "insert into wallet_history values(?,?,?,?,?)";
	public static final String SQL_GET_WALLET_HISTORY = "select * from wallet_history";
	public static final String SQL_GET_WALLET_DETAILS = "select * from wallet where w_id = ?";
	public static final String SQL_GET_USER_RATING = "select avg(rating) as avg_rating from rating where u_id = ?";
	public static final String SQL_INSERT_RATING_DRIEVR = "insert into rating(rating,feedback,u_id) values(?,?,?)";
	public static final String SQL_GET_MONEY = "select * from wallet where w_id = ?";
	/*
	 *  user ride related queries
	 */
	public static final String SQL_GET_USERRIDE = "select r_id,u_id,status,no_of_seats,requested_time,accepted_time from user_ride where r_id = ? and u_id=?";
	public static final String SQL_CREATE_USERRIDE = "insert into user_ride values(?,?,?,?,?,?)";
	public static final String SQL_UPDATE_USERRIDE_STATUS = "update user_ride set status = ? where u_id = ? and r_id = ? and status='requested'";

	
	/*
	 *  ride related queries
	 */
	public static final String GET_ALL_RIDES = "select * from ride r inner join vehicle v where r.v_id = v.v_id";
	public static final String GET_RIDE = "select * from ride r inner join vehicle v where r.v_id = v.v_id and r_id = :id";
	public static final String CREATE_RIDE = "insert into ride values(:id,:driver_id,:v_id,:source,:destination,:ride_date,:created_date,:cost)";
	
	
	/*
	 *  user module queries
	 */
	public static final String SQL_GET_USER_BY_ID = "select u_id, email, password,w_id, user_name from carpooling.user where u_id = ?";
	public static final String SQL_GET_USERS = "select * from carpooling.user";
	public static final String SQL_CREATE_USER = "insert into carpooling.user values(?, ?, sha(?), ?, ?);";
	public static final String SQL_UPDATE_USER = "update user set  email = ?, password = ?, user_name = ? where u_id = ?";
	public static final String SQL_DELETE_USER = "delete from carpooling.user where u_id=?";
	
	/*
	 * login module
	 */
	public static final String SQL_USER_VALIDATE = "select u_id,email, password, user_name from carpooling.user where  email=? and password=sha1(?) ";
	

}
