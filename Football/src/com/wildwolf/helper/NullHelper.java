package com.wildwolf.helper;
/**
 * 
 * @author ����ϼ
 * 2011-11-21 ����06:22:46
 */
public class NullHelper {
	
	public static String empty(String s) {
		if (s == null) {
			return new String();
		}
		return s;
	}

}
