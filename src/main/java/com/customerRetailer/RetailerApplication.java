package com.customerRetailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.customerRetailer")
public class RetailerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerApplication.class, args);
	}

}
