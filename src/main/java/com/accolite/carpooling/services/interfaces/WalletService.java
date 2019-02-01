package com.accolite.carpooling.services.interfaces;

import java.util.Date;

/**
 * wallet related operations can be done using wallet services
 *
 */
public interface WalletService {

	/**
	 * adds money to wallet
	 * 
	 * @param amt  amount
	 * @param wId wallet id
	 * @param uId user id
	 * @param date current date
	 * @return amount added
	 */
	public int addMoney(int amt, int wId, int uId, Date date);

	/**
	 * transfers money from one wallet to another
	 * 
	 * @param amt   amount to b transfered
	 * @param swId source wallet id
	 * @param dwId destination wallet id
	 * @param rId  ride id
	 * @param uId  user id
	 * @param time  current time
	 */
	public void transferMoney(int amt, int swId, int dwId, int rId, int uId, Date time);

	/**
	 * gets the wallet balance
	 * 
	 * @param wId wallet id
	 * @return balance
	 */
	public int getMoney(int wId);
}
