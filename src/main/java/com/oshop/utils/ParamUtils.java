package com.oshop.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamUtils {

	@Autowired
	private HttpServletRequest request;
	
	// Đọc chuỗi giá trị của tham số
	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}
	
	// Đọc số nguyên giá trị của tham số
	public int getInt(String name, int defaultValue) {
		String value = request.getParameter(name);
		if(value == null) {
			return defaultValue;
		}
		return Integer.parseInt(value);
	}
	
	// Đọc số thực giá trị của tham số
	public double getDouble(String name, double defaultValue) {
		String value = request.getParameter(name);
		if (value == null) {
			return defaultValue;
		}
		return Double.parseDouble(value);
	}
	
	// Đọc giá trị boolean của tham số
	public boolean getBoolean(String name, boolean defaultValue) {
		String value = request.getParameter(name);
		if (value == null) {
			return defaultValue;
		}
		return Boolean.parseBoolean(value);
	}
	
	// Đọc giá trị thời gian của tham số
	public Date getDate(String name, String pattern) {
		String value = request.getParameter(name);
		if (value == null) {
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.parse(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Lưu file upload vào thư mục
	public File saveFile(MultipartFile file, String path) {
		if (file.isEmpty()) {
			return null;
		}
		try {
			File dir = new File(request.getServletContext().getRealPath(path));
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File dest = new File(dir, file.getOriginalFilename());
			file.transferTo(dest);
			return dest;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Lấy cơ sở url
	public String getSiteURL() {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}
	
	
}
