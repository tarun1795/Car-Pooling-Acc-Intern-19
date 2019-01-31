package com.accolite.carpooling.dto;

public class PassWordRecoveryDTO {
	
	private String to_mail;
	private String subject;
	private String text;
	private String link;
	public String getTo_mail() {
		return to_mail;
	}
	public void setTo_mail(String to_mail) {
		this.to_mail = to_mail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

}
