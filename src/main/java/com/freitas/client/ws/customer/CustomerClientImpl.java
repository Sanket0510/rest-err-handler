package com.freitas.client.ws.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;

import com.freitas.client.ws.BaseWebServiceClientImpl;
import com.freitas.client.ws.MyRequestCallback;
import com.freitas.client.ws.MyResponseExtractor;
import com.freitas.client.ws.Response;
import com.freitas.exception.BaseException;
import com.freitas.exception.CustomerException;
import com.freitas.exception.ErrorCodeCustomerEnum;
import com.freitas.exception.RestError;
import com.freitas.model.Customer;


public class CustomerClientImpl extends BaseWebServiceClientImpl implements CustomerClient {
	
	
	public Customer saveCustomer(Customer customer) {
		
		if (customer == null) {
			throw new CustomerException(ErrorCodeCustomerEnum.INVALID_PARAMS, 
					"Customer is empty");
		}
		
		Response response = null;
		RequestCallback requestCallback = new MyRequestCallback(null, customer, restTemplate.getMessageConverters());
		MyResponseExtractor responseExtractor = new MyResponseExtractor(Customer.class, restTemplate.getMessageConverters());
		
		response = restTemplate.execute(getServiceUrl() + "/ws/customer", 
				HttpMethod.POST, requestCallback, responseExtractor);
		
		if (response == null){
			// FIXME: need to log this
			System.out.println("Response is null");
			throw new IllegalArgumentException("REST response is null");
		}
		if (!response.isFoundError()){
			Customer results = (Customer) response.getResponse();
			return results;
		}
		else {
			// need to convert RestError back into exception and throw it
			RestError restError = response.getErrResponse();
			BaseException ex = restError.transformRestError();
			// can do i18n here, for now just go with default
			ex.setMessage(ex.getErrorCode().getDefaultMessage());
			throw ex;
		}
	}
	
	public Customer getCustomerByName(String name) {
		
		if (name == null || name.isEmpty()) {
			throw new CustomerException(ErrorCodeCustomerEnum.INVALID_PARAMS, 
					"A valid name is required");
		}
		
		Response response = null;
		RequestCallback requestCallback = new MyRequestCallback();
		MyResponseExtractor responseExtractor = new MyResponseExtractor(Customer.class, restTemplate.getMessageConverters());
		
		// create params for request
		Map<String,Object> uriVariables = new HashMap<String,Object>();
		uriVariables.put("name", name);
		
		response = restTemplate.execute(getServiceUrl() + "/ws/customer?name={name}", 
				HttpMethod.GET, requestCallback, responseExtractor, uriVariables);
		// could throw one of HttpClientErrorException, HttpServerErrorException or
		// RestClientException and the caller will need to catch and handle these
		
		if (response == null){
			// FIXME: need to log this
			System.out.println("Response is null");
			throw new IllegalArgumentException("REST response is null");
		}
		if (!response.isFoundError()){
			Customer customer = (Customer) response.getResponse();
			return customer;
		}
		else {
			// need to convert RestError back into exception and throw it
			RestError restError = response.getErrResponse();
			BaseException ex = restError.transformRestError();
			// can do i18n here, for now just go with default
			ex.setMessage(ex.getErrorCode().getDefaultMessage());
			throw ex;
		}
	}
	
	
	
	
}
