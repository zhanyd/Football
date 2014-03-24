package com.wildwolf.helper;

public class RightsException extends Exception{
	private String message;
	
	public RightsException()
	{
		super();
	}
	public RightsException(String messgae)
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
