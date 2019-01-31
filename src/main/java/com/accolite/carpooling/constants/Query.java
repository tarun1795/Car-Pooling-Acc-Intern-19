package com.accolite.carpooling.constants;

public class Query {
	
	public static final String SQL_ADD_MONEY = "update wallet set amount = ? where w_id = ? ";
	public static final String SQL_TRANSFER_MONEY = "update wallet set amount = ? where w_id = ?";
	public static final String SQL_TRANSFER_MONEY_HISTORY = "insert into wallet_history(r_id, u_id, amount_paid, transaction_date, status) values(?,?,?,?,?)";
	public static final String SQL_GET_WALLET_HISTORY = "select * from wallet_history";
	public static final String SQL_GET_WALLET_DETAILS = "select * from wallet where w_id = ?";
	public static final String SQL_GET_USER_RATING = "select avg(rating) as avg_rating from rating where u_id = ?";
	public static final String SQL_INSERT_RATING_DRIEVR = "insert into rating(rating,feedback,u_id) values(?,?,?)";
	public static final String SQL_GET_MONEY = "select * from wallet where w_id = ?";
	
}
