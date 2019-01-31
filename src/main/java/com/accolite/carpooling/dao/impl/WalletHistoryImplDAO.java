package com.accolite.carpooling.dao.impl;

import com.accolite.carpooling.constants.Query;
import com.accolite.carpooling.dao.interfaces.WalletHistoryDAO;
import com.accolite.carpooling.models.WalletHistory;
import com.accolite.carpooling.rowmappers.WalletHistoryMapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class WalletHistoryImplDAO implements WalletHistoryDAO{

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<WalletHistory> getAllHistoryDetails() {
		return jdbcTemplate.query(Query.SQL_GET_WALLET_HISTORY, new Object[] { }, new WalletHistoryMapper());
	}

}
