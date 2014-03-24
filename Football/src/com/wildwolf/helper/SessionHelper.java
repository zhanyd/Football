package com.wildwolf.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author oujianhua
 * 2011-11-14 15:33
 *
 */
public class SessionHelper {
	private HttpSession session;
	

	public SessionHelper(HttpServletRequest request) {
		session = request.getSession();
	}
	
	
	public void setAttribute(String name, Object value) {
		session.removeAttribute(name);
		session.setAttribute(name, value);
	}
	
	public Object getAttribute(String name) {
		return session.getAttribute(name);
	}
	

}
