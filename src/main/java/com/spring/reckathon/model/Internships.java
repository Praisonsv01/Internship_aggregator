package com.spring.reckathon.model;

public class Internships {

	private String internshipID;
	private String companyID;
	private String title;
	private String description;
	private String requirements;
	private int stipend;
	private String location;
	
	public String getInternshipID() {
		return internshipID;
	}
	public void setInternshipID(String internshipID) {
		this.internshipID = internshipID;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public int getStipend() {
		return stipend;
	}
	public void setStipend(int stipend) {
		this.stipend = stipend;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Internships(String companyID, String title, String description, String requirements, int stipend,
			String location) {
		super();
		this.companyID = companyID;
		this.title = title;
		this.description = description;
		this.requirements = requirements;
		this.stipend = stipend;
		this.location = location;
	}
	public Internships() {
		super();
	}
	
	
}
