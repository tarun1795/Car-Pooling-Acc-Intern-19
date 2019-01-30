package com.accolite.carpooling.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.carpooling.dao.interfaces.WalletMoneyDao;
import com.accolite.carpooling.services.interfaces.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	WalletMoneyDao walletMoneyImplDAO;

	public WalletServiceImpl() {
	}

	@Override
	public void addMoney(int amt, int w_id) {
		boolean result = walletMoneyImplDAO.AddMoney(amt, w_id);
		System.out.println(result);
	}

	@Override
	public void transferMoney(int amt, int sw_id, int dw_id) {
		boolean result = walletMoneyImplDAO.TransferMoney(amt, sw_id, dw_id);
		System.out.println(result);
	}

}
