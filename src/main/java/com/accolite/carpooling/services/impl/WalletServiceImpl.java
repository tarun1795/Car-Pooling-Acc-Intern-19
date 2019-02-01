package com.accolite.carpooling.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.WalletMoneyDAO;
import com.accolite.carpooling.services.interfaces.WalletService;

@Service
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	WalletMoneyDAO walletMoneyImplDAO;
	
	/*
	 * (non-Javadoc)
	 * @see com.accolite.carpooling.services.interfaces.WalletService#addMoney(int, int, int, java.util.Date)
	 */
	@Override
	public int addMoney(int amt, int wId, int uId, Date date) {
		return walletMoneyImplDAO.addMoneyDAO(amt, wId, uId, date);
	}
	
	@Override
	public void transferMoney(int amt, int swId, int dwId,int rId, int uId, Date date) {
		walletMoneyImplDAO.transferMoneyDAO(amt, swId, dwId,rId, uId, date);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.accolite.carpooling.services.interfaces.WalletService#getMoney(int)
	 */
	@Override
	public int getMoney(int wId) {
		return walletMoneyImplDAO.getMoneyDAO(wId);
	}

}
