package com.cg.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.webapp.beans.Merchant;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.repositories.MerchantRepository;

import lombok.extern.slf4j.Slf4j;

//import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

	
	@Autowired
	private MerchantRepository mRepo;
	
	
	
	@Override
	public Merchant registerNewMerchant(Merchant merchant) {
		
		log.info("Registered New Merchant");
        return mRepo.save(merchant);
	

	}

	@Override
	public Merchant viewMerchantByUsername(String email) throws MerchantNotFoundException {
		
		Merchant merchant= mRepo.findByEmail(email);
		
		
		if(merchant == null)
	
			throw new MerchantNotFoundException("Invalid merchant email..");
		else
			log.info("Registered New Merchant");
			return merchant;
		
		
	}

	@Override
	public Merchant updateMerchant(Merchant merchant) throws MerchantNotFoundException {
		
		Optional<Merchant> opt= mRepo.findById(merchant.getMerchantId());
		
		
		if(opt.isPresent()) {
			log.info(" New Merchant Added..");
			return mRepo.save(merchant);
		}
		else
			throw new MerchantNotFoundException("Invalid Merchant....");
		
		
		
	}

	@Override
	public List<Merchant> getAllRegisteredMerchant() {
		log.info("All Registered Merchant");
		return mRepo.findAll();
		
		
	}

	@Override
	public Merchant deleteAMerchant(Integer merchantId) throws MerchantNotFoundException {
		
		Optional<Merchant> opt=mRepo.findById(merchantId);
		
		
		if(opt.isPresent()) {
			
			Merchant merchant= opt.get();
			mRepo.delete(merchant);
			log.info("Merchant record deleted");
			return merchant;
			
			
		}else
			throw  new MerchantNotFoundException("invalid Merchant Id...");
		
		
		
	}

	@Override
	public Merchant authenticateMerchant(String email, String password) throws MerchantNotFoundException {
	
		Merchant merchant= mRepo.findByEmailAndPassword(email, password);
		
		if(merchant == null)
			throw new MerchantNotFoundException("Invalid Username or password for merchant");
		else
			return merchant;
	}

}
