package com.cg.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.webapp.beans.Customer;
import com.cg.webapp.beans.IPackage;
import com.cg.webapp.exception.CustomerNotFoundException;
import com.cg.webapp.exception.PackageNotAvailableException;
import com.cg.webapp.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Override
	public Customer registerNewCustomer(Customer customer) {
		log.info("Registered New Customer");
	 return cRepo.save(customer);
	
	
	
	}

	@Override
	public Customer authenticateCustomer(String email, String password) throws CustomerNotFoundException {
		Customer customer = cRepo.findByEmailAndPassword(email,password);
		if(customer == null)
		{
			throw new CustomerNotFoundException("Invalid username or password");
		}else
			
			return customer;
		
	}

	@Override
	public Customer getCustomerDetailsById(Integer customerId) throws CustomerNotFoundException {
		return cRepo.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("No cusotmer with id: " + customerId + " found!!"));
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
         cRepo.findById(customer.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("No cusotmer with id: " + customer+ " found!!"));	
		   cRepo.save(customer);
		   log.info("Updated the Customer");
		return customer;
	}

	@Override
	public List<Customer> getAllRegistedCustomers() {
		log.info("All Registered Customers");
		return cRepo.findAll();
	}

	@Override
	public List<IPackage> getAllPackagesByCustomer(Integer customerId) throws CustomerNotFoundException {
		Optional<Customer> opt= cRepo.findById(customerId);
		if (opt.isPresent()) {
		Customer customer=opt.get();
		return customer.getPackages();
		
		}
		else {
			throw new CustomerNotFoundException("Customer not found");
		}
		
	}

	  
	

	
}
