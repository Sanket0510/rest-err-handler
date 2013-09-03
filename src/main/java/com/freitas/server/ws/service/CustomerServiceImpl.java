package com.freitas.server.ws.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.freitas.exception.CustomerException;
import com.freitas.exception.ErrorCodeCustomerEnum;
import com.freitas.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private static Logger log = Logger.getLogger(CustomerServiceImpl.class);
	
	private Map<String,Customer> customerMap = new HashMap<String,Customer>();
	private long lastId = 3;
	
	public CustomerServiceImpl() {
		customerMap.put("bob", new Customer(1L, "bob"));
		customerMap.put("fred", new Customer(2L, "fred"));
		customerMap.put("sarah", new Customer(3L, "sarah"));
	}

	public Customer saveCustomer(Customer customer){
		
		log.debug("Enter saveCustomer in CustomerServiceImpl with customer " + customer.getName());
		
		lastId++;
		
		log.debug("Created new entry with id " + lastId);
		
		customerMap.put(customer.getName(), customer);
		return customer;

	}

	
	public Customer getCustomerByName(String name) throws CustomerException {

		log.debug("Enter getCustomerByName in CustomerServiceImpl with customer " + name);

		Customer customer = customerMap.get(name);
		if (customer == null){
			String msg = " Customer not found with name: " + name;
			log.error(ErrorCodeCustomerEnum.NOT_FOUND.getName() + msg);
			throw new CustomerException(ErrorCodeCustomerEnum.NOT_FOUND, msg);
		}

		return customer;
	}


	public boolean deleteCustomerByName(String name) throws CustomerException {

		log.debug("Enter deleteCustomer in TestMgmtServiceImpl with name" + name);
		
		Customer customer = getCustomerByName(name);
		if (customer == null){
			log.error("On delete by id " + ErrorCodeCustomerEnum.NOT_FOUND.getName());
			throw new CustomerException(ErrorCodeCustomerEnum.NOT_FOUND, "Exception: Unable to find customer in database");
		}
		else {
			customerMap.remove(customer);
		}
		return true;

	}

}
