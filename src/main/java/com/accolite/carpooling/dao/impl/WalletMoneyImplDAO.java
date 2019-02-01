package com.accolite.carpooling.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.WalletMoneyDAO;
import com.accolite.carpooling.models.WalletMoney;
import com.accolite.carpooling.rowmappers.GetMoneyMapper;
import com.accolite.carpooling.rowmappers.WalletMoneyMapper;

@Repository
public class WalletMoneyImplDAO implements WalletMoneyDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private WalletMoney walletMoney;
	
	@Override
	public int addMoneyDAO(int amt, int wId, int uId, Date date) {
		jdbcTemplate.update(Query.SQL_TRANSFER_MONEY_HISTORY, -1, uId, amt, date, "Money Added to your wallet");
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { wId },new WalletMoneyMapper());
		boolean res = jdbcTemplate.update(Query.SQL_ADD_MONEY, walletMoney.getAmt()+amt, walletMoney.getWId())>0;
		if(res) {
			walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { wId },new WalletMoneyMapper());
		}
		return walletMoney.getAmt();
	}
	
	@Override
	public boolean transferMoneyDAO(int rideAmt, int swId, int dwId, int rId, int uId, Date date) {
		jdbcTemplate.update(Query.SQL_TRANSFER_MONEY_HISTORY, rId, uId, rideAmt, date, "Money paid for ride" );
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { swId },new WalletMoneyMapper());
		boolean a = jdbcTemplate.update(Query.SQL_TRANSFER_MONEY, (walletMoney.getAmt()-rideAmt), swId)>0;
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { dwId },new WalletMoneyMapper());
		boolean b = jdbcTemplate.update(Query.SQL_TRANSFER_MONEY, (walletMoney.getAmt()+rideAmt), dwId)>0;
		return a&&b;
	}
	
	@Override
	public int getMoneyDAO(int wId) {
		try {
			walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_MONEY, new Object[] { wId }, new GetMoneyMapper());
			return walletMoney.getAmt();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return -1;
		}
	}
	
}
