package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.WalletHistory;

/**
 * row mapper for wallethistory
 *
 */
public class WalletHistoryMapper implements RowMapper<WalletHistory> {

	public WalletHistory mapRow(ResultSet resultSet, int i) throws SQLException {

		WalletHistory wh = new WalletHistory();
		wh.setTransactionId(resultSet.getInt("transaction_id"));
		wh.setrId(resultSet.getInt("r_id"));
		wh.setuId(resultSet.getInt("u_id"));
		wh.setAmount(resultSet.getInt("amount_paid"));
		wh.setStatus(resultSet.getString("status"));
		wh.setTransactionDate(resultSet.getDate("transaction_date"));

		return wh;

	}
}
