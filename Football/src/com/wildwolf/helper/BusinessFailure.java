package com.wildwolf.helper;
/**
 * 
 * @author ����ϼ
 * 2011-8-17 ����10:35:23
 */
public class BusinessFailure extends Throwable{

//	private String prefix = "�ܱ�Ǹ��ϵͳ���ִ���:";

	public BusinessFailure(String message) {		
		super(message);
//		super(new StringBuffer().append(message).append(",").append("�ܱ�Ǹ��ϵͳ�����˴�������ϵŷ�������绰13968882643").toString());
	}
} 
