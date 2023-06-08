package com.fakeSocial.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BackApplication {
	public static final Logger logger = LoggerFactory.getLogger(BackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args); 
	}

}
