package com.cg.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cg.webapp.beans.IAdmin;
import com.cg.webapp.repositories.AdminRepository;

@Component
public class AdminRunner implements CommandLineRunner {

	
	@Autowired
	private AdminRepository aRepo;
	@Override
	public void run(String... args) throws Exception {
	    IAdmin admin = new IAdmin();
	    admin.setName("Admin");
	    admin.setUsername("Admin123@gmail.com");
	    admin.setPassword("Admin1234");
	    aRepo.save(admin);
		
	}

}
