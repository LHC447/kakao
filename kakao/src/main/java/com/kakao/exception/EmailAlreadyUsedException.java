package com.kakao.exception;

public class EmailAlreadyUsedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;

	public EmailAlreadyUsedException() {
		this.message= "Email is already used.";
	}

	public EmailAlreadyUsedException(String msg){
		  this.message = msg;
		}

	@Override
	public String getMessage() {
		 return message;
	}
	
	
}
