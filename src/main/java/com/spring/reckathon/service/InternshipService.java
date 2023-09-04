package com.spring.reckathon.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.reckathon.dao.ExeQuery;
import com.spring.reckathon.model.Internships;

@Service
public class InternshipService {

	@Autowired
	ExeQuery query;

	public List<Internships> getInternshipsByLocation(String location) throws SQLException {
		return query.getInternshipsByLocation(location);
	}

	public String getCompanyName(String companyID) {
		return query.getCompanyName(companyID);
	}

	public List<Internships> getInternshipsByCompany(String companyName) {
		String companyID = query.getCompanyID(companyName);
		System.out.println("companyName:" + companyName);
		System.out.println("companyID:" + companyID);
		return getInternshipsByCompany(companyID);
	}

	public Internships getInternshipsByTitle(String title) throws SQLException {
		return query.getInternshipsByTitle(title);
	}
	
}
