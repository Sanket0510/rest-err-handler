package com.freitas.exception;

public interface ErrorCodeEnum {
	
	int getErrorCode();
	String getName();
	int getServiceId();
	String getMessageKey();
	String getDefaultMessage();

}
