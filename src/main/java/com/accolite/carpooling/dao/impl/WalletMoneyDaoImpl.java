package com.accolite.carpooling.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.WalletMoneyDao;
import com.accolite.carpooling.models.WalletMoney;
import com.accolite.carpooling.rowmappers.WalletMoneyMapper;

@Repository
public class WalletMoneyDaoImpl implements WalletMoneyDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private WalletMoney walletMoney;
	
	@Override
	public boolean AddMoney(int amt, int w_id) {
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { w_id },new WalletMoneyMapper());
		return jdbcTemplate.update(Query.SQL_ADD_MONEY, walletMoney.getAmt()+amt, walletMoney.getW_id())>0;
	}
	
	@Override
	public boolean TransferMoney(int ride_amt, int sw_id, int dw_id) {
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { sw_id },new WalletMoneyMapper());
		boolean a = jdbcTemplate.update(Query.SQL_TRANSFER_MONEY, (walletMoney.getAmt()-ride_amt), sw_id)>0;
		walletMoney = jdbcTemplate.queryForObject(Query.SQL_GET_WALLET_DETAILS, new Object[] { dw_id },new WalletMoneyMapper());
		boolean b = jdbcTemplate.update(Query.SQL_TRANSFER_MONEY, (walletMoney.getAmt()+ride_amt), dw_id)>0;
		return a&&b;
	}
	
}
