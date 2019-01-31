package com.accolite.carpooling.services.interfaces;

import java.util.Date;

public interface WalletService {

	public int addMoney(int amt, int w_id, int u_id, Date date);
	public void transferMoney(int amt, int sw_id, int dw_id, int r_id, int u_id, Date time);
	public int getMoney(int w_id);
}
