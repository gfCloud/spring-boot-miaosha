package com.miaosha.agent.exception;

import com.miaosha.agent.result.CodeMsg;

public class GlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private CodeMsg cm;
	
	public GlobalException(CodeMsg cm){
		super(cm.toString());
		this.cm = cm;
	}
	public CodeMsg getCm() {
		return cm;
	}
	
	
}
