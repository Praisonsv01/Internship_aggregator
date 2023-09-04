package com.spring.reckathon.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.reckathon.model.Internships;
import com.spring.reckathon.service.InternshipService;

@Controller
public class InternshipController {

	@Autowired
	InternshipService service;
	
	@GetMapping("searchinternship")
	public String getSearchInternshipByLocation() {
		return "searchinternships";
	}
	
	@PostMapping("searchinternshipbylocation")
	public ModelAndView postSearchInternshipByLocation(@RequestParam("location") String location) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Internships> internships = service.getInternshipsByLocation(location);
		List<String> companyNames = new ArrayList<>();
		
		for(Internships internship: internships) {
			String companyID = internship.getCompanyID();
			String companyName = service.getCompanyName(companyID);
			companyNames.add(companyName);
		}
		mv.addObject("companyNames", companyNames);
		mv.addObject("internships", internships);
		mv.setViewName("internlistbylocation");
		return mv;
	}
	
	@PostMapping("intern-details")
	public ModelAndView getInternDetails(@RequestParam("companyID") String companyID, @RequestParam("title") String title) throws SQLException {
		ModelAndView mv = new ModelAndView();
		String companyName = service.getCompanyName(companyID);
		Internships internship = service.getInternshipsByTitle(title);
		System.out.println("companyName " + companyID);
		System.out.println("internship " + title);
		mv.addObject("companyName", companyName);
		mv.addObject("internship", internship);
		mv.setViewName("interndetails");
		
		return mv;
	}
	
	
	@PostMapping("searchinternshipbycompany")
	public ModelAndView postSearchInternshipByCompany(@RequestParam("company") String companyName) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Internships> internships = service.getInternshipsByCompany(companyName);
		System.out.println("companyName from controller:" +companyName);
		mv.addObject("companyName", companyName);
		mv.addObject("internships", internships);
		mv.setViewName("internlistbycompany");
		return mv;
	}
}
