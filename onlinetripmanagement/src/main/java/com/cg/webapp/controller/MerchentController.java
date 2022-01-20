package com.cg.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.webapp.beans.LoginBean;
import com.cg.webapp.beans.Merchant;
import com.cg.webapp.beans.IPackage;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.exception.PackageNotFoundException;
import com.cg.webapp.service.MerchantService;
import com.cg.webapp.service.PackageService;

@RestController
public class MerchentController {

	@Autowired
	private MerchantService mService;
	
	@PostMapping("/registerMerchant")
	public ResponseEntity<Merchant> registerMerchantHandler(@Valid @RequestBody Merchant merchant){
		
	 	Merchant savedMerchant= mService.registerNewMerchant(merchant);
		
	 	
	 	return new ResponseEntity<Merchant>(savedMerchant,HttpStatus.CREATED);
		
	}
	
	
	
	@PostMapping("/loginMerchant")
	public ResponseEntity<Merchant> loginMerchantHandler(@Valid@RequestBody LoginBean loginBean){
		
		if(loginBean.getRole().equals("merchant")) {
			
			Merchant merchant= mService.authenticateMerchant(loginBean.getUsername(), loginBean.getPassword());
		
			
			return new ResponseEntity<Merchant>(merchant,HttpStatus.OK);
			
		}
		else
			throw new MerchantNotFoundException("Invalid Role...");
		
		
		
	}

	@GetMapping("/viewMerchantByUsername/{email}")
    public ResponseEntity<Merchant>  viewMerchantByUsername( @PathVariable String email){
		Merchant viewMerchant =mService. viewMerchantByUsername(email);
	 return new ResponseEntity<Merchant>(viewMerchant,HttpStatus.OK);
	
	}

	
	@PutMapping("/updateMerchant") 
 	public ResponseEntity<Merchant> updateMerchant(@Valid@RequestBody Merchant merchant) {
 		return new ResponseEntity<Merchant>(mService.updateMerchant(merchant), HttpStatus.OK);
	}

	@GetMapping("/getRegisteredMerchant/{merchantId}")
	public List<Merchant> getAllRegisteredMerchant()  {
		return mService.getAllRegisteredMerchant();
	}
	
	@DeleteMapping("/deleteMerchant/{merchantId}")
	public ResponseEntity<Merchant> deleteAMerchant(@PathVariable Integer merchantId) {
 		return new ResponseEntity<Merchant>(mService.deleteAMerchant(merchantId), HttpStatus.OK);
	
	}
	
	
	
	
	
}