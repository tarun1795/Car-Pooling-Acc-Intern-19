package com.accolite.carpooling.models;

import java.sql.Date;

/**
 * Wallet history table object
 *
 */
public class WalletHistory {

	private int transactionId;
	private int uId;
	private int rId;
	private int amount;
	private String status;
	private Date transactionDate;

	

	public int getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}



	public int getuId() {
		return uId;
	}



	public void setuId(int uId) {
		this.uId = uId;
	}



	public int getrId() {
		return rId;
	}



	public void setrId(int rId) {
		this.rId = rId;
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



	public Date getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	public String toString() {
		return "[ t_id = " + transactionId + ", u_id =" + uId + ", r_id = " + rId + "amount = " + amount
				+ ", transaction_date = " + transactionDate + "status = " + status + " ]";
	}
}
