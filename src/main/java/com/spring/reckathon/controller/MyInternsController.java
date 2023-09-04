package com.spring.reckathon.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.reckathon.model.Internships;
import com.spring.reckathon.model.MyInterns;
import com.spring.reckathon.service.MyInternsService;

@Controller
public class MyInternsController {
	
	@Autowired
	MyInternsService service;

	@PostMapping("apply-intern")
	public ModelAndView postApplyIntern(@RequestParam("title") String title,HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		
		service.addMyIntern(title, (String) session.getAttribute("email"));
		mv.setViewName("searchinternships");
		return mv;
	}
	
	@GetMapping("my-interns")
	public ModelAndView getMyInterns(HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		
		String email = (String)session.getAttribute("email");
		System.out.println(email);
		
		List<MyInterns> myInternsList = service.getMyInternsByEmail(email);
		System.out.println("myInternsList: " + myInternsList);

		List<Internships> internships = new ArrayList<>();
		System.out.println("internships : " + internships );
		
		List<String> companyNames = new ArrayList<>();
		for(MyInterns myinterns: myInternsList) {
			Internships intern = new Internships();
			intern = service.getInternshipsByTitle(myinterns.getTitle());
			companyNames.add(service.getCompanyName(intern.getCompanyID()));
			internships.add(intern);
		}
		
		mv.addObject("companyNames",companyNames);
		mv.addObject("internships", internships);
		mv.setViewName("myinterns");
		return mv;
	}
	
	@PostMapping("delete-intern")
	public String deleteIntern(@RequestParam("title") String title, HttpSession session) {
		service.deleteIntern((String)session.getAttribute("email"), title);
		return "redirect:/my-interns";
	}
}
