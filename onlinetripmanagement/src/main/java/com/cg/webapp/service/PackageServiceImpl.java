package com.cg.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.webapp.beans.Merchant;
import com.cg.webapp.beans.IPackage;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.exception.PackageNotFoundException;
import com.cg.webapp.repositories.MerchantRepository;
import com.cg.webapp.repositories.PackageRepository;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class PackageServiceImpl implements PackageService {
	
	@Autowired
	private PackageRepository pRepo;
	
	@Autowired
	private MerchantRepository mRepo;
	

	@Override
	public IPackage createANewTripPackage(IPackage tripPackage) {
		log.info("Created New Trip Package");
		return pRepo.save(tripPackage);
		
		
	}

	@Override
	public IPackage getPackageDetailsById(Integer packageId) throws PackageNotFoundException {
		return pRepo.findById(packageId)
				.orElseThrow(() -> new PackageNotFoundException("No cusotmer with id: " + packageId + " found!!"));
	}
	
	@Override
	public List<IPackage> getAllPackagesCreatedyMerchant(Integer merchantId) throws MerchantNotFoundException {
		
		Optional<Merchant> opt= mRepo.findById(merchantId);
		
		if(opt.isPresent()) {
			
			Merchant merchant= opt.get();
			
			log.info("All packages created by merchant");
			return merchant.getPackages();
			
			
			
			
		}else
			throw new  MerchantNotFoundException("Invalid Merchant Id");
		
		
		
		
	}

	@Override
	public List<IPackage> getAllPackagesCreatedyMerchantbyEmail(String merchantEmail) throws MerchantNotFoundException {
		
		Merchant merchant= mRepo.findByEmail(merchantEmail);
		
		if(merchant == null)
			throw new MerchantNotFoundException("Invalid Merchant Email...");
		else
			return merchant.getPackages();
		
	}

	@Override
	public List<IPackage> getAllPackages() {
		log.info("All packages are listed");
		return pRepo.findAll();
	}

	@Override
	public IPackage updatePackage(IPackage tripPackage) {
		// TODO Auto-generated method stub
		return pRepo.save(tripPackage);
	}

	
	
	
	
}
