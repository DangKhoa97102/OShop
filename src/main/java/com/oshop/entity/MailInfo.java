package com.oshop.entity;

import java.io.Serial;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MailInfo implements Serializable {
	@Serial
	private static final long serialVersionUID = -8879605138713118486L;

	private String from;
	private String to;
	private String[] cc;
	private String[] bcc;
	private String subject;
	private String body;
	private MultipartFile[] attachments;
	
	public MailInfo(String to, String subject, String body) {
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	
	public MailInfo(String from, String to, String subject, String body) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
}
