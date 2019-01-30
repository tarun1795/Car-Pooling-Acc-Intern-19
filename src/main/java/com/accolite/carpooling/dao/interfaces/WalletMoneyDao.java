package com.accolite.carpooling.dao.interfaces;

public interface WalletMoneyDao {
	public boolean AddMoney(int amt, int w_id);
	public boolean TransferMoney(int ride_amt, int sw_id, int dw_id);
}
