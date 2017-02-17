package com.java.oracle.dao;

import com.java.oracle.entity.Customer;

public class CustomerDAO extends AbstractDAO<Customer> {
    
    public CustomerDAO(Class<Customer> clzz) {
        super(Customer.class);
    }
    
    
}
