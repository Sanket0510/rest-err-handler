package com.freitas.server.ws.service;

import com.freitas.exception.CustomerException;
import com.freitas.model.Customer;

public interface CustomerService {
	
	Customer saveCustomer(Customer customer);
	Customer getCustomerByName(String name) throws CustomerException;
	boolean deleteCustomerByName(String name) throws CustomerException;

}
