package com.wildwolf.helper;
/**
 * 
 * @author 王艳霞
 * 2011-8-17 下午10:35:23
 */
public class BusinessFailure extends Throwable{

//	private String prefix = "很抱歉，系统出现错误:";

	public BusinessFailure(String message) {		
		super(message);
//		super(new StringBuffer().append(message).append(",").append("很抱歉，系统出现了错误，请联系欧健华，电话13968882643").toString());
	}
} 
