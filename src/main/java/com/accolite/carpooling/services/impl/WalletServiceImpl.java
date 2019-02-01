package com.accolite.carpooling.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.WalletMoneyDao;
import com.accolite.carpooling.services.interfaces.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	WalletMoneyDao walletMoneyDaoImpl;

	@Override
	public int addMoney(int amt, int wId, int uId, Date date) {
		return walletMoneyDaoImpl.addMoneyDAO(amt, wId, uId, date);
	}

	@Override
	public void transferMoney(int amt, int swId, int dwId, int rId, int uId, Date date) {
		walletMoneyDaoImpl.transferMoneyDAO(amt, swId, dwId, rId, uId, date);
	}

	@Override
	public int getMoney(int wId) {
		return walletMoneyDaoImpl.getMoneyDAO(wId);
	}

}
