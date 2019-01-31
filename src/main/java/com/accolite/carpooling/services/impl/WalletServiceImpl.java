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
	
	@Override
	public int addMoney(int amt, int w_id, int u_id, Date date) {
		int result = walletMoneyImplDAO.AddMoney(amt, w_id, u_id, date);
		System.out.println(result);
		return result;
	}
	
	@Override
	public void transferMoney(int amt, int sw_id, int dw_id,int r_id, int u_id, Date date) {
		System.out.println(walletMoneyImplDAO.TransferMoney(amt, sw_id, dw_id,r_id, u_id, date));
	}
	
	@Override
	public int getMoney(int w_id) {
		return walletMoneyImplDAO.GetMoney(w_id);
	}

}
