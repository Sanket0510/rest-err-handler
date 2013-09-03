package com.freitas.exception;

import java.util.Map;

public class CustomerException extends BaseException {
	
	private static final long serialVersionUID = 8823356956725033191L;

	public CustomerException(ErrorCodeEnum errorCode) {
		super();
		this.setErrorCode(errorCode);
	}
	
	public CustomerException(ErrorCodeEnum errorCode, String debugMessage) {
		super();
		this.setErrorCode(errorCode);
		this.setDebugMessage(debugMessage);
	}
	
	public CustomerException(ErrorCodeEnum errorCode, String debugMessage, 
			Map<String, String> messageArgs) {
		super();
		this.setErrorCode(errorCode);
		this.setDebugMessage(debugMessage);
		this.messageArgs = messageArgs;
	}

}
