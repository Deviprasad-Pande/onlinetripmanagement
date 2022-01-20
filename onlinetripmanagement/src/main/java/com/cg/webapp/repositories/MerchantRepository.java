package com.cg.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.webapp.beans.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant,Integer>{

	public Merchant findByEmail(String email);
	
	public Merchant findByEmailAndPassword(String email,String password); 
}
