package com.cg.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.webapp.beans.Merchant;
import com.cg.webapp.beans.IPackage;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.exception.PackageNotFoundException;
import com.cg.webapp.service.MerchantService;
import com.cg.webapp.service.PackageService;



@RestController
public class PackageController {

	@Autowired
	private PackageService pService;

	
	@Autowired
	private MerchantService mService;
	
	
	@PostMapping("/createPackage/{merchantEmail}")
	public IPackage createAPackageHandler(@Valid @RequestBody IPackage tripPackage, @PathVariable String merchantEmail) {
		
		Merchant merchant= mService.viewMerchantByUsername(merchantEmail);
		
		tripPackage.setMerchant(merchant);
		tripPackage.setAvailability(tripPackage.getNumberOfPackages());
		
		 return pService.createANewTripPackage(tripPackage);
		 }
		 
		 
     @GetMapping("/getPackageDetailsById/{packageId}")
			public ResponseEntity<IPackage> getPackageDetailsById(@PathVariable Integer packageId)  {
				IPackage pack = pService.getPackageDetailsById(packageId);
				return new ResponseEntity<>(pack, HttpStatus.OK);
				}
				
     @GetMapping("/getPackagesCreatedById")
 	public List<IPackage> getAllPackagesCreatedyMerchant(@PathVariable Integer merchantId) {
 		return pService.getAllPackagesCreatedyMerchant(merchantId);
				
     }
     
     @GetMapping("/getPackagesByEmail/{merchantEmail}")
     public List<IPackage> getAllPackagesCreatedyMerchantbyEmail( @PathVariable String merchantEmail){
		return pService.getAllPackagesCreatedyMerchantbyEmail(merchantEmail);
	}
     
     @GetMapping("/getAllPackages")
 	public List<IPackage> getAllPackages() {
 		return pService.getAllPackages();
	
     }
     
     @PutMapping("/updatePackage") 
 	public ResponseEntity<IPackage> updatePackage(@Valid@RequestBody IPackage tripPackage) {
 		return new ResponseEntity<>(pService.updatePackage(tripPackage), HttpStatus.OK);
 	}
	
	
	 
	
	
	
	
	
	
}
