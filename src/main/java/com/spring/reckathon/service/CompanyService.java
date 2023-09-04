package com.spring.reckathon.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.reckathon.dao.ExeQuery;
import com.spring.reckathon.model.Company;

@Service
public class CompanyService {

	@Autowired
	ExeQuery query;
	
	public List<Company> getAllCompanies() throws SQLException{
		return query.getAllCompanies();
	}

	public void processCompanyData(Map<String, String> companyData) {
		query.addCompany(companyData);
	}
}
