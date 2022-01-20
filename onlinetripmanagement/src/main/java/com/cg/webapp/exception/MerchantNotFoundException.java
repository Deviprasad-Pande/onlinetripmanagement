package com.cg.webapp.exception;

public class MerchantNotFoundException extends RuntimeException {

	
	public MerchantNotFoundException() {
		
	}
	
	public MerchantNotFoundException(String message) {
		super(message);
	}
	
}
