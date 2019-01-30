package com.accolite.carpooling.services.interfaces;

import java.sql.Date;

public interface WalletService {

	public void addMoney(int amt, int w_id);
	public void transferMoney(int amt, int sw_id, int dw_id);
}
