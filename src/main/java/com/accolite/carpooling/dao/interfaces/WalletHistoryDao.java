package com.accolite.carpooling.dao.interfaces;

import java.util.List;

import com.accolite.carpooling.models.WalletHistory;

public interface WalletHistoryDao {

	public List<WalletHistory> getAllHistoryDetails(int uId);

}
