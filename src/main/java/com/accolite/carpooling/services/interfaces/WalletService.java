package com.accolite.carpooling.services.interfaces;

import java.util.Date;

/**
 * wallet related operations can be done using wallet services
 *
 */
public interface WalletService {

	/**
	 * adds money to wallet
	 * @param amt amount
	 * @param w_id wallet id
	 * @param u_id user id
	 * @param date current date
	 * @return amount added
	 */
	public int addMoney(int amt, int w_id, int u_id, Date date);
	
	/**
	 * transfers money from one wallet to another
	 * @param amt amount to b transfered
	 * @param sw_id source wallet id
	 * @param dw_id dest wallet id
	 * @param r_id ride id
	 * @param u_id user id
	 * @param time current time
	 */
	public void transferMoney(int amt, int sw_id, int dw_id, int r_id, int u_id, Date time);
	
	/**
	 * gets the wallet balance
	 * @param w_id wallet id
	 * @return balance
	 */
	public int getMoney(int w_id);
}
