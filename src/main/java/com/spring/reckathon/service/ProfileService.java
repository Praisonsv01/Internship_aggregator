package com.spring.reckathon.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.reckathon.dao.ExeQuery;
import com.spring.reckathon.model.Education;
import com.spring.reckathon.model.User;

@Service
public class ProfileService {

	@Autowired
	ExeQuery query;

	public User ShowProfile(String email) {
		User user = query.getUser(email);
		return user;
	}

	public void changePassword(String password, String email) {
		query.updatePassword(password, email);
	}

	public void changeName(String name, String email) {
		query.updateName(name, email);
	}

	public void changePhoneno(String phoneno, String email) {
		query.updatePhoneno(phoneno, email);
	}
	
	public void addEducation(String email, String degree, String fieldOfStudy, String institute , String startDate, String endDate, String percentage) {
		query.addEducation(email, degree, fieldOfStudy, institute, startDate, endDate, percentage);
	}

	public List<Education> getEducationList(String email) throws SQLException {
		return query.getEducationList(email);
	}

	public void updatedegree(String degree, int courseId, String email) {
	    query.updatedegree(degree, courseId, email);
	}

	public void updateFieldOfStudy(String fieldOfStudy, int courseId, String email) {
	    query.updateFieldOfStudy(fieldOfStudy, courseId, email);
	}

	public void updateInstitute(String institute, int courseId, String email) {
	    query.updateInstitute(institute, courseId, email);
	}

	public void updateStartDate(String startDate, int courseId, String email) {
	    query.updateStartDate(startDate, courseId, email);
	}

	public void updateEndDate(String endDate, int courseId, String email) {
	    query.updateEndDate(endDate, courseId, email);
	}

	public void updatePercentage(String percentage, int courseId, String email) {
	    query.updatePercentage(percentage, courseId, email);
	}

}
