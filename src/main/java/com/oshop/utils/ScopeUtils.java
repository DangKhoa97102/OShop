package com.oshop.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Cung cấp các phương thức đọc/ghi attribute trong các scope
 */
@Service
public class ScopeUtils {

	@Autowired
	private HttpServletRequest request;
	
	/**
	 * Tạo attribute trong request scope
	 * */
	public void setRequest(String name, Object value) {
		request.setAttribute(name, value);
	}
	
	/**
	 * Đọc attribute trong request scope
	 **/
	@SuppressWarnings("unchecked")
	public <T> T getRequest(String name) {
		return (T) request.getAttribute(name);
	}
	
	/**
	 * Xóa attribute trong request scope
	 **/
	public void removeRequest(String name) {
		request.removeAttribute(name);;
	}
	
	/**
	 * Tạo attribute trong session scope
	 **/
	public void setSession(String name, Object value) {
		request.getSession().setAttribute(name, value);
	}
	
	/**
	 * Đọc attribute trong session scope
	 **/
	@SuppressWarnings("unchecked")
	public <T> T getSession(String name) {
		return (T) request.getSession().getAttribute(name);
	}
	
	/**
	 *  Xóa attribute trong session scope
	 **/
	public void removeSession(String name) {
		request.getSession().removeAttribute(name);
	}
	
	/**
	 *  Tạo attribute trong application scope
	 **/
	public void setApplication(String name, Object value) {
		request.getServletContext().setAttribute(name, value);
	}
	
	/**
	 *  Đọc attribute trong application scope
	 **/
	@SuppressWarnings("unchecked")
	public <T> T getApplication(String name) {
		return (T) request.getServletContext().getAttribute(name);
	}
	
	/**
	 *  Xóa attribute trong application scope
	 **/
	public void removeApplication(String name) {
		request.getServletContext().removeAttribute(name);
	}
	
	
	
}
