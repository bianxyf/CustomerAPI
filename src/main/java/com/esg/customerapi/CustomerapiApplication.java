package com.esg.customerapi;

import com.esg.customerapi.model.Customer;
import com.esg.customerapi.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerapiApplication {

	private static final Logger log = LoggerFactory.getLogger(CustomerapiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerapiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// Save couple of Customers
			repository.save(new Customer("123", "Bianca", "Findlay", "1 Home Road", "", "Manchester", "", "United Kingdom", "M22 5PR"));
			repository.save(new Customer("125", "Bianca", "Smithy", "4 Home Road", "", "Manchester", "", "United Kingdom", "M23 5PR"));

			// Fetch all Customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// Fetch a Customer by ID
			Customer customer = repository.findCustomerByCustomerReference("123");
			log.info("Customer with CustomerReference: 123 FOUND:");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");
			// Fetch a non-existing customer
			Customer customer2 = repository.findCustomerByCustomerReference("1111");
			if (customer2 == null) {
				log.info("Customer with CustomerReference: 1111 NOT FOUND.");
			} else {
				log.info("Customer found with findByCustomerReference():");
				log.info("--------------------------------");
				log.info(customer2.toString());
			}
		};
	}

}
