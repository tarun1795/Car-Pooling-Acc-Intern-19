package com.accolite.carpooling.services.interfaces;

import java.util.Date;

public interface WalletService {

	public int addMoney(int amt, int wId, int uId, Date date);
	public void transferMoney(int amt, int swId, int dwId, int rId, int uId, Date time);
	public int getMoney(int wId);
}
