package com.cg.webapp.service;

import java.util.List;

import com.cg.webapp.beans.IPackage;
import com.cg.webapp.beans.Merchant;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.exception.PackageNotFoundException;

public interface PackageService {
	
	public IPackage createANewTripPackage(IPackage tripPackage);
	
	public IPackage getPackageDetailsById(Integer packageId)throws PackageNotFoundException;
	
	public List<IPackage> getAllPackagesCreatedyMerchant(Integer merchantId)throws MerchantNotFoundException;

	public List<IPackage> getAllPackagesCreatedyMerchantbyEmail(String merchantEmail)throws MerchantNotFoundException;
	public List<IPackage> getAllPackages();
	
	public IPackage updatePackage(IPackage tripPackage);
	
	public IPackage deletePackage(Integer packageId)throws PackageNotFoundException;
	
	
	
	
	
	
}
