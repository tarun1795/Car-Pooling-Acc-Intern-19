package com.accolite.carpooling.dao.interfaces;
import java.util.List;

import com.accolite.carpooling.models.WalletHistory;
public interface WalletHistoryDAO {
	
	public List<WalletHistory> getAllHistoryDetails(int wId);
	
}
