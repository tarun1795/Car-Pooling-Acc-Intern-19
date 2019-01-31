package com.accolite.carpooling.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.WalletMoneyDao;
import com.accolite.carpooling.models.WalletMoney;
import com.accolite.carpooling.rowmappers.GetMoneyMapper;
import com.accolite.carpooling.rowmappers.WalletMoneyMapper;


/**
 * Wallet table related operations 
 */
@Repository
public class WalletMoneyDaoImpl implements WalletMoneyDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private WalletMoney walletMoney;

	
	/**
	 * used to add money to the wallet
	 */
	@Override
	public int AddMoney(int amt, int w_id, int u_id, Date date) {
		int ans = jdbcTemplate.update(Query.SQL_TRANSFER_MONEY_HISTORY, -1, u_id, amt, date,
				"Money Added to your wallet");
		System.out.println(ans);
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { w_id },
				new WalletMoneyMapper());
		boolean res = jdbcTemplate.update(Query.SQL_ADD_MONEY, walletMoney.getAmt() + amt, walletMoney.getW_id()) > 0;
		if (res == true) {
			walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { w_id },
					new WalletMoneyMapper());
		}
		return walletMoney.getAmt();
	}

	
	/**
	 * used to transfer money from source wallet to dest wallet
	 */
	@Override
	public boolean TransferMoney(int ride_amt, int sw_id, int dw_id, int r_id, int u_id, Date date) {
		int ans = jdbcTemplate.update(Query.SQL_TRANSFER_MONEY_HISTORY, r_id, u_id, ride_amt, date,
				"Money paid for ride");
		System.out.println(ans);
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { sw_id },
				new WalletMoneyMapper());
		boolean a = jdbcTemplate.update(Query.SQL_TRANSFER_MONEY, (walletMoney.getAmt() - ride_amt), sw_id) > 0;
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { dw_id },
				new WalletMoneyMapper());
		boolean b = jdbcTemplate.update(Query.SQL_TRANSFER_MONEY, (walletMoney.getAmt() + ride_amt), dw_id) > 0;
		return a && b;
	}

	/**
	 * used to get the amount in the wallet
	 */
	@Override
	public int GetMoney(int w_id) {
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_MONEY, new Object[] { w_id }, new GetMoneyMapper());
		return walletMoney.getAmt();
	}

}
