package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.WalletMoney;

/**
 * row mapper for wallet
 *
 */
public class WalletMoneyMapper implements RowMapper<WalletMoney> {

	public WalletMoney mapRow(ResultSet resultSet, int i) throws SQLException {

		WalletMoney wm = new WalletMoney();
		wm.setAmt(resultSet.getInt("amount"));
		wm.setW_id(resultSet.getInt("w_id"));
		return wm;
	}
}
