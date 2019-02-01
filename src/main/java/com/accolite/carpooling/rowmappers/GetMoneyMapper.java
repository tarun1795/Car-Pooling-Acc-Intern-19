package com.accolite.carpooling.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.carpooling.models.WalletMoney;

public class GetMoneyMapper implements RowMapper<WalletMoney> {

	@Override
	public WalletMoney mapRow(ResultSet resultSet, int i) throws SQLException{
		WalletMoney walletMoney = new WalletMoney();
		walletMoney.setWId(resultSet.getInt("w_id"));
		walletMoney.setAmt(resultSet.getInt("amount"));
		return walletMoney;
	}
}
