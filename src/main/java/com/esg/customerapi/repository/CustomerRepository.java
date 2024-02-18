package com.esg.customerapi.repository;

import com.esg.customerapi.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository <Customer, Long>{

    Customer findCustomerByCustomerReference(@Param("CustomerReference") String custRef);
}
