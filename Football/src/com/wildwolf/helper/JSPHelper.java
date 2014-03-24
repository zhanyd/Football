package com.wildwolf.helper;

/**
 * 
 * @author oujianhua
 * 2011-8-20 обнГ11:07:12
 */
public class JSPHelper {
	
	/**
	 * generate html space
	 * @param numberOfSpace
	 * @return
	 */
	public static String generateHtmlSpace(int numberOfSpace) {
		StringBuffer sb = new StringBuffer();
		for (int i =0; i< numberOfSpace; i++) {
			sb.append("&nbsp;");
		}
		return sb.toString();
	}

}
