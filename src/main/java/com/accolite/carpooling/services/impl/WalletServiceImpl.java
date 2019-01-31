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
	
	public WalletServiceImpl() {
	
	}
	
	@Override
	public void addMoney(int amt, int w_id, int u_id, Date date) {
		boolean result = walletMoneyImplDAO.AddMoney(amt, w_id, u_id, date);
		System.out.println(result);
	}
	
	@Override
	public void transferMoney(int amt, int sw_id, int dw_id,int r_id, int u_id, Date date) {
		boolean result = walletMoneyImplDAO.TransferMoney(amt, sw_id, dw_id,r_id, u_id, date);
		System.out.println(result);
	}

}
