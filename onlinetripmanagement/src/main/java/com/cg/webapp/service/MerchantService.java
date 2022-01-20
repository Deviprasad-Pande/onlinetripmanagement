package com.cg.webapp.service;

import java.util.List;

import com.cg.webapp.beans.Merchant;
import com.cg.webapp.exception.MerchantNotFoundException;

public interface MerchantService {
	
	public Merchant registerNewMerchant(Merchant merchant);
	
	public Merchant viewMerchantByUsername(String email)throws MerchantNotFoundException;

	public Merchant updateMerchant(Merchant merchant)throws MerchantNotFoundException;
	
	public List<Merchant> getAllRegisteredMerchant();
	
	public Merchant deleteAMerchant(Integer merchantId)throws MerchantNotFoundException;
	
	public Merchant authenticateMerchant(String email,String password)throws MerchantNotFoundException;
	
}
