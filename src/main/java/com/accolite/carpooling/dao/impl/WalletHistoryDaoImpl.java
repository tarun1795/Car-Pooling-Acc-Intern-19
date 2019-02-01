package com.accolite.carpooling.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.WalletHistoryDao;
import com.accolite.carpooling.models.WalletHistory;
import com.accolite.carpooling.rowmappers.WalletHistoryMapper;

/**
 * Wallet History table related operations
 *
 */
@Component
public class WalletHistoryDaoImpl implements WalletHistoryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * gets all the wallet history table entries
	 */
	@Override
	public List<WalletHistory> getAllHistoryDetails(int u_id) {
		return jdbcTemplate.query(Query.SQL_GET_WALLET_HISTORY, new Object[] { u_id }, new WalletHistoryMapper());
	}

}
