package com.spring.reckathon.model;

public class Company {

	private String companyID;
	private String companyName;
	private String website;
	private String contactEmail;
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public Company() {
		
	}
	
	public Company(String companyID, String companyName, String website, String contactEmail) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.website = website;
		this.contactEmail = contactEmail;
	}
	
	
}
