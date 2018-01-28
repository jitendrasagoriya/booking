package com.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:query.properties")
public class BookingApplication {
	
	private static Logger logger = LoggerFactory.getLogger(BookingApplication.class);

	public static void main(String[] args) {		 
		SpringApplication.run(BookingApplication.class, args);
	}
}
