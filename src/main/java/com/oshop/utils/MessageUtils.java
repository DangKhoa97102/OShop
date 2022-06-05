package com.oshop.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

@Service
public class MessageUtils {

	@Autowired
	HttpServletRequest request;
	@Autowired
	LocaleResolver localResolver;
	@Autowired
	MessageSource message;

	public String getMessage(String code, Object[] args) {
		return message.getMessage(code, args, localResolver.resolveLocale(request));
	}
	
	public String getMessage(String code) {
		return getMessage(code, null);
	}
}
