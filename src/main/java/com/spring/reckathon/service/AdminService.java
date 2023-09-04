package com.spring.reckathon.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.reckathon.dao.ExeQuery;
import com.spring.reckathon.model.User;

@Service
public class AdminService {
	
	@Autowired
	ExeQuery query;
	

	public List<User> getAllUser() {
		return query.getAllUser();
	}
	
	public User getUserBasedOnName(String name) throws SQLException {
		return query.getUserBasedOnName(name);
	}

}
