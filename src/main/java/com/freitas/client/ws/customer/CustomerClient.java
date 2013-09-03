package com.freitas.client.ws.customer;

import com.freitas.client.ws.BaseWebServiceClient;
import com.freitas.model.Customer;
;

public interface CustomerClient extends BaseWebServiceClient {
	
	Customer saveCustomer(Customer customer);
	Customer getCustomerByName(String name);
	
}
