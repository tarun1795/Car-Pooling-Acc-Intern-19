package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.*;

/**
 * row mapper for wallethistory
 *
 */
public class WalletHistoryMapper  implements RowMapper<WalletHistory> {
	
	
	public WalletHistory mapRow(ResultSet resultSet, int i) throws SQLException {

		WalletHistory wh = new WalletHistory();
		wh.setTransaction_id(resultSet.getInt("transaction_id"));
		wh.setR_id(resultSet.getInt("r_id"));
		wh.setU_id(resultSet.getInt("u_id"));
		wh.setAmount(resultSet.getInt("amount_paid"));
		wh.setStatus(resultSet.getString("status"));
		wh.setTransaction_date(resultSet.getDate("transaction_date"));
		
		return wh;
		
	}
}
