package com.freitas.server.ws;

import com.freitas.exception.CustomerException;
import com.freitas.exception.ErrorCodeCustomerEnum;
import com.freitas.model.Customer;

public class WSValidator {
	
	public void validateString(String param, String paramName) {
		if (param == null || param.isEmpty()) {
			throw new CustomerException(ErrorCodeCustomerEnum.INVALID_PARAMS, 
					paramName + " is required");
		}
	}
	
	
	public void validateLong(Long param, String paramName) {
		if (param == null || param.equals(0L)) {
			throw new CustomerException(ErrorCodeCustomerEnum.INVALID_PARAMS, 
					paramName + " is required");
		}
	}
	
	public void validateCustomer(Customer customer) {
		if (customer == null) {
			throw new CustomerException(ErrorCodeCustomerEnum.INVALID_PARAMS, 
					"Customer is empty");
		}
		if (customer.getName() == null || customer.getName().isEmpty()) {
			throw new CustomerException(ErrorCodeCustomerEnum.INVALID_PARAMS, 
					"Customer name is required");
		}
	}

}
