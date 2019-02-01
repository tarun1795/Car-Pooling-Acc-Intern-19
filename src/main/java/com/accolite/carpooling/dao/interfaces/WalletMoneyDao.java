package com.accolite.carpooling.dao.interfaces;

import java.util.Date;

public interface WalletMoneyDao {
	public int addMoneyDAO(int amt, int wId, int uId, Date date);

	public boolean transferMoneyDAO(int rideAmt, int swId, int dwId, int rId, int uId, Date date);

	public int getMoneyDAO(int wId);
}
