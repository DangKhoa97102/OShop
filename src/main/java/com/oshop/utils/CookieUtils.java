package com.oshop.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieUtils {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	public Cookie getCookieValue(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}
		return null;
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
		cookie.setPath(name);
		response.addCookie(cookie);
	}
	
	public ProductUpdated toProductUpdated () {
        ProductUpdated productUpdated = new ProductUpdated();
        productUpdated.setId(this.getId());
        productUpdated.setName(this.getName());
        productUpdated.setSlug(this.getSlug());
        productUpdated.setImage(this.getImage());
        productUpdated.setImagePreview1(this.getImagePreview1());
        productUpdated.setImagePreview2(this.getImagePreview2());
        productUpdated.setImagePreview3(this.getImagePreview3());
        productUpdated.setImagePreview4(this.getImagePreview4());
        productUpdated.setVideoPreview(this.getVideoPreview());
        productUpdated.setDescription(this.getDescription());
        productUpdated.setQuantity(this.getQuantity());
        productUpdated.setPrice(this.getPrice());
        productUpdated.setCreatedDate(this.getCreatedDate());
        productUpdated.setAvailable(this.getAvailable());
        productUpdated.setCategorySlug(this.getCategory().getSlug());
        productUpdated.setBrandSlug(this.getBrand().getSlug());
        productUpdated.setDiscountId(this.getDiscount() == null ? null : this.getDiscount().getId());
        return productUpdated;
    }
	
}
