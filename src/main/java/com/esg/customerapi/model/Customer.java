package com.esg.customerapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long ID;
    @Getter
    @Setter
    private String customerReference;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String addressLine1;
    @Getter
    @Setter
    private String addressLine2;
    @Getter
    @Setter
    private String town;
    @Getter
    @Setter
    private String county;
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private String postCode;

    protected Customer() {}

    public Customer(String custRef, String firstName, String lastName, String add1, String add2,
                    String town, String county, String country, String postCode) {
        this.customerReference = custRef;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLine1 = add1;
        this.addressLine2 = add2;
        this.town = town;
        this.county = county;
        this.country = country;
        this.postCode = postCode;
    }
}
