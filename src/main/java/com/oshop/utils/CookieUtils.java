package com.oshop.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oshop.dto.ProductUpdated;

@Service
public class CookieUtils {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	public Cookie getCookie(String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }
	
	public String getCookieValue(String name) {
		 Cookie cookie = getCookie(name);
	        if (cookie == null) {
	            return "";
	        }
	        return cookie.getValue();
	}
	
	public void setCookie(String name, String value, int hours) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours * 60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public void removeCookie(String name) {
		Cookie cookie = new Cookie(name, "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
}
