package com.freitas.exception;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ErrorCodeCustomerEnum implements ErrorCodeEnum {
	
	
	UNKNOWN_ERROR(1, "UNKNOWN_ERROR", "customer.error.unknown"),
	INVALID_PARAMS(2, "INVALID_PARAMS", "customer.error.params.invalid"),
	NOT_FOUND(3, "NOT_FOUND", "customer.error.entity.notfound"),
	DUP_CUSTNAME(4, "DUP_CUSTNAME", "customer.error.entity.dup.cust"),
	
	//FIXME: add more here
	
	;
	
	// lookup table to be used to find enum for conversion
	private static final Map<Integer,ErrorCodeCustomerEnum> lookup = new HashMap<Integer,ErrorCodeCustomerEnum>();
	static {
		for(ErrorCodeCustomerEnum e : EnumSet.allOf(ErrorCodeCustomerEnum.class))
			lookup.put(e.getErrorCode(), e);
	}
	
	private static ServiceEnum serviceEnum = ServiceEnum.CUSTOMER_SERVICE;
	private int errorCode;
	private String name;
	private String i18nKey;
	
	ErrorCodeCustomerEnum(int errorCode, String name, String i18nKey) {
		this.errorCode = errorCode;
		this.name = name;
		this.i18nKey = i18nKey;
	}
	
	public int getErrorCode() {
		return this.errorCode;
	}
	
	public String getName() {
		return this.name;
	}

	public int getServiceId() {
		return serviceEnum.getServiceId();
	}

	public String getMessageKey() {
		return i18nKey;
	}

	public String getDefaultMessage() {
		switch (this){
		case UNKNOWN_ERROR:
			return "An unknown error has been encountered";
		case INVALID_PARAMS:
			return "Invalid parameters were received";
		case NOT_FOUND:
			return "Requested entity was not found";
		case DUP_CUSTNAME:
			return "Duplicate customer name used";
		
		//FIXME: add more here and can use resource bundle with i18nKey if desired 
		
		default: 
			return "An undefined error has been encountered";
		}
	}
	
	public static ErrorCodeCustomerEnum get(int errorCode) { 
		return lookup.get(errorCode); 
	}


}
