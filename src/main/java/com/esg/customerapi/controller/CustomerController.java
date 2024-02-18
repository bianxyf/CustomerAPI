package com.esg.customerapi.controller;

import com.esg.customerapi.repository.CustomerRepository;
import com.esg.customerapi.model.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository custRepo) {
        this.customerRepository = custRepo;
    }

    @PostMapping("/saveCustomerDetail")
    public Customer saveCustomerDetails(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    @GetMapping("/getCustomerDetail/{customerReference}")
    public Customer getCustomerDetails(@PathVariable String customerReference){
        return customerRepository.findCustomerByCustomerReference(customerReference);
    }
}
