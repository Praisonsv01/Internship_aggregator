package com.spring.reckathon.model;

public class Education {
	
	private int courseid;
	private String email;
	private String degree;
	private String fieldOfStudy;
	private String institute;
	private String startDate;
	private String endDate;
	private String percentage;
	
	public int getCourseId() {
		return courseid;
	}

	public void setCourseId(int courseid) {
		this.courseid = courseid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	public Education(){
		
	}

	public Education(String degree, String fieldOfStudy, String institute, String startDate, String endDate, String percentage) {
		super();
		this.degree = degree;
		this.fieldOfStudy = fieldOfStudy;
		this.institute = institute;
		this.startDate = startDate;
		this.endDate = endDate;
		this.percentage = percentage;
	}

}
