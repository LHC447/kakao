package com.kakao.exception;

public class EmailAlreadyUsedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;

	public EmailAlreadyUsedException() {
		this.message= "이미 사용중인 이메일입니다.";
	}

	public EmailAlreadyUsedException(String msg){
		  this.message = msg;
		}

	@Override
	public String getMessage() {
		 return message;
	}
	
	
}
