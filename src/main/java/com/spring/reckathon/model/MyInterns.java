package com.spring.reckathon.model;

public class MyInterns {

	private String email;
	private String title;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MyInterns(String email, String title) {
		super();
		this.email = email;
		this.title = title;
	}

	public MyInterns() {
		super();
	}

}
