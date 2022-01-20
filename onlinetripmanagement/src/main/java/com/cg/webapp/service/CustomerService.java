package com.cg.webapp.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.cg.webapp.beans.IPackage;
import com.cg.webapp.beans.Customer;
import com.cg.webapp.exception.CustomerNotFoundException;

public interface CustomerService {
	
	public Customer registerNewCustomer(Customer customer);
	
	public Customer authenticateCustomer(String email,String password)throws CustomerNotFoundException ;

	public Customer getCustomerDetailsById(Integer customerId)throws CustomerNotFoundException;
	
	public Customer updateCustomer(Customer customer)throws CustomerNotFoundException;
	
	public List<Customer> getAllRegistedCustomers();
	
	public List<IPackage> getAllPackagesByCustomer(Integer customerId)throws CustomerNotFoundException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerNotFoundException;
		
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
