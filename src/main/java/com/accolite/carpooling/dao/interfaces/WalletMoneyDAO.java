package com.accolite.carpooling.dao.interfaces;

import java.util.Date;

public interface WalletMoneyDAO {
	public int AddMoney(int amt, int w_id, int u_id, Date date);
	public boolean TransferMoney(int ride_amt, int sw_id, int dw_id,int r_id, int u_id, Date date);
	public int GetMoney(int u_id);
}
