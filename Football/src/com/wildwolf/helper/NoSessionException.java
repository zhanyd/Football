package com.wildwolf.helper;

public class NoSessionException extends Exception{
private String message;
	
	public NoSessionException()
	{
		super();
	}
	public NoSessionException(String messgae)
	{
		super(messgae);
		this.message = messgae;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
