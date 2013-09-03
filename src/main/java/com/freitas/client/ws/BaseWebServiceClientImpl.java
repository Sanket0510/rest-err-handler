package com.freitas.client.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class BaseWebServiceClientImpl implements BaseWebServiceClient {
	
	protected RestTemplate restTemplate;
	private String serviceUrl;

	@Override
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	@Override
	public String getServiceUrl() {
		return serviceUrl;
	}
	
	
	public BaseWebServiceClientImpl() { }
	
	public BaseWebServiceClientImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		MyResponseErrorHandler errorHandler = new MyResponseErrorHandler();
		restTemplate.setErrorHandler(errorHandler);
	}

	
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		MyResponseErrorHandler errorHandler = new MyResponseErrorHandler();
		restTemplate.setErrorHandler(errorHandler);
	}

}
