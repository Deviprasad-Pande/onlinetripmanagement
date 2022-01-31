package com.cg.webapp.controller;

import java.util.ArrayList;
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

import com.cg.webapp.beans.Customer;
import com.cg.webapp.beans.LoginBean;
import com.cg.webapp.beans.Merchant;
import com.cg.webapp.beans.IPackage;
import com.cg.webapp.exception.CustomerNotFoundException;
import com.cg.webapp.exception.MerchantNotFoundException;
import com.cg.webapp.exception.PackageNotAvailableException;
import com.cg.webapp.service.CustomerService;
import com.cg.webapp.service.PackageService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	@Autowired
	private PackageService pService;
	
	@PostMapping("/registerCustomer")
	public ResponseEntity<Customer> registerNewCustomer(@Valid@RequestBody Customer customer) {
		return new ResponseEntity<>(cService.registerNewCustomer(customer), HttpStatus.OK);
	}
	

		@PostMapping("/loginCustomer")
		public ResponseEntity<Customer> loginCustomerHandler(@Valid@RequestBody LoginBean loginBean){
			
			if(loginBean.getRole().equals("customer")) {
				
				Customer customer= cService.authenticateCustomer(loginBean.getUsername(), loginBean.getPassword());
			
				
				return new ResponseEntity<Customer>(customer,HttpStatus.OK);
				
			}
			else
				throw new CustomerNotFoundException("Invalid Role...");
			
			
		}
		@GetMapping("/getCustomerById/{customerid}")
		public ResponseEntity<Customer> getCustomerDetailsById(@PathVariable Integer customerId) {
			Customer customer = cService.getCustomerDetailsById(customerId);
			return new ResponseEntity<>(customer, HttpStatus.OK);
	
		}
		
		@PutMapping("/updateCustomer")
		public ResponseEntity<Customer> updateCustomer(@Valid@RequestBody Customer customer) {
			return new ResponseEntity<>(cService.updateCustomer(customer), HttpStatus.OK);
		}
		
		
		@GetMapping("/getCustomers")
		public ResponseEntity<List<Customer>> getAllRegisteredCustomers() {
			return new ResponseEntity<>(cService.getAllRegistedCustomers(), HttpStatus.OK);
		}
	
		@GetMapping("/getCustomerById/{customerId}")
		public List<IPackage> getAllPackagesByCustomer(@PathVariable Integer customerId) {
	 		return cService.getAllPackagesByCustomer(customerId);
		}
	
		@DeleteMapping("/deleteCustomerById/{customerId}")
		public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer customerId){
			return new ResponseEntity<Customer>(cService.deleteCustomer(customerId), HttpStatus.OK);
			
		}
		
		@PostMapping("/bookPackage/{customerId}/{packageId}")
		public String bookPackage(@PathVariable Integer customerId, @PathVariable Integer packageId ) throws Exception {
			
			IPackage ipackage   = pService.getPackageDetailsById(packageId);
			Customer customer = cService.getCustomerDetailsById(customerId);
			
			return cService.bookPackage(ipackage, customer);
	
	
	
	
		}	
}
