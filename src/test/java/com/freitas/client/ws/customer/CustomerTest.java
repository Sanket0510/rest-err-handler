package com.freitas.client.ws.customer;

import static org.junit.Assert.*;

import com.freitas.client.ws.BaseTestCase;
import com.freitas.exception.BaseException;
import com.freitas.exception.ErrorCodeCustomerEnum;
import com.freitas.model.Customer;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerTest extends BaseTestCase {
	
	private CustomerClient wsClient;
	
	private String custName = "bob";
	
	@Autowired
	public void setClientService(CustomerClient clientService) {
		wsClient = clientService;
	}
	
	@Test
	public void testGetCustomerByName() {
		
		Customer customer = wsClient.getCustomerByName(custName);
		assertNotNull(customer);
		assertEquals(custName, customer.getName());
		
		
		try {
			customer = wsClient.getCustomerByName("SomeBogusName");
			fail("Expected an exception here");
		}
		catch(BaseException pe) {
			assertEquals(ErrorCodeCustomerEnum.NOT_FOUND.getErrorCode(), 
					pe.getErrorCode().getErrorCode());
		}
	}
	

}
