package com.spring.reckathon.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.reckathon.dao.ExeQuery;
import com.spring.reckathon.model.Internships;
import com.spring.reckathon.model.MyInterns;

@Service
public class MyInternsService {

	@Autowired
	ExeQuery query;

	public String getCompanyName(String companyID) {
		return query.getCompanyName(companyID);
	}
	
	public Internships getInternshipsByTitle(String title) throws SQLException {
		return query.getInternshipsByTitle(title);
	}
	
	public void saveMyIntern(String email, String title) {
		query.saveMyIntern(email, title);
	}

	public List<MyInterns> getMyInternsByEmail(String email) throws SQLException {
		return query.getMyInternsByEmail(email);
	}

	public void deleteIntern(String email, String title) {
		query.deleteIntern(email, title);
	}

	public void addMyIntern(String title, String email) throws SQLException {
		query.addMyIntern(title, email);
	}

	public List<MyInterns> getAllInterns() throws SQLException {
		return query.getAllInterns();
	}
}
