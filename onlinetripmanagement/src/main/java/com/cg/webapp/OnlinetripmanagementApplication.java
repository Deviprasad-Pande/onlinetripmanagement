package com.cg.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
@Slf4j
public class OnlinetripmanagementApplication {

	public static void main(String[] args) {

	  
		
		log.info("Online Trip Management Application Started");

		SpringApplication.run(OnlinetripmanagementApplication.class, args);


		log.info("Online Trip Management Application Configured");
	}
	
}
