package com.accolite.carpooling.models;

import java.sql.Date;

public class WalletHistory {
	
	private int transaction_id;
	private int u_id;
	private int r_id;
	private int amount;
	private String status;
	private Date transaction_date;
	
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "[ t_id = " + transaction_id + ", u_id =" + u_id + ", r_id = " + r_id + "amount = " + amount + ", transaction_date = "+transaction_date+"status = " + status + " ]";
	}
}
