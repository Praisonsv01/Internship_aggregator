package com.spring.reckathon.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.reckathon.model.Company;
import com.spring.reckathon.model.Education;
import com.spring.reckathon.model.Internships;
import com.spring.reckathon.model.MyInterns;
import com.spring.reckathon.model.User;
import com.spring.reckathon.service.AdminService;
import com.spring.reckathon.service.CompanyService;
import com.spring.reckathon.service.MyInternsService;
import com.spring.reckathon.service.ProfileService;

@Controller
public class AdminController {
	
	
	@Autowired
	AdminService service;
	
	@Autowired
	ProfileService profileservice;
	
	@Autowired
	CompanyService companyservice;
	
	@Autowired
	MyInternsService myinternsservice;

	
	
	@GetMapping("/admin-login")
	public String adminLogin() {
		return "adminLogin";
	}
	
	@GetMapping("/admin-dashboard")
	public String getadminDashboard(HttpServletRequest request) throws SQLException {
		List<Company> companies = companyservice.getAllCompanies();
		request.setAttribute("companies", companies);
		return "admindashboard";
	}
	
	@PostMapping("/admin-dashboard")
	public String afterLogin(HttpServletRequest request) throws Exception {

		String adminName = request.getParameter("adminname");
		String password = request.getParameter("password");
		if (adminName.equals("admin") && password.equals("admin123")) {
			List<User> userList = service.getAllUser();
			List<Company> companies = companyservice.getAllCompanies();
			request.setAttribute("companies", companies);
			request.setAttribute("userList", userList);
			return "admindashboard";
		} else {
	        request.setAttribute("errorMessage", "Invalid username or password");
			return "adminLogin";
		}
	}
	
	@GetMapping("/registered-users")
	public String registeredUsers(HttpServletRequest request) throws Exception {

			List<User> userList = service.getAllUser();
			request.setAttribute("userList", userList);
			return "registeredusers";
		
	}
	
	@GetMapping("userprofile")
	public String getUserProfile(HttpServletRequest request, 
			@RequestParam("name") String name) throws SQLException {

		System.out.println("name:" +name);
		User user= service.getUserBasedOnName(name);
		System.out.println("user: " + user);
		request.setAttribute("user", user);
		return "userprofile";
	}
	
	@PostMapping("getEducationalDetails")
	public ModelAndView getEducation(@RequestParam("userName") String name,HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		User user= service.getUserBasedOnName(name);
		List<Education> educationList = profileservice.getEducationList(user.getEmail());
		mv.addObject("user", user);
		mv.addObject("educationList", educationList);
		mv.setViewName("vieweducation");
		return mv;
	}
	
	@GetMapping("allregistered-interns")
	public ModelAndView getMyInterns() throws SQLException {
		ModelAndView mv = new ModelAndView();
		
		List<MyInterns> myInternsList = myinternsservice.getAllInterns();
		System.out.println("myInternsList: " + myInternsList);

		List<Internships> internships = new ArrayList<>();
		System.out.println("internships : " + internships );
		
		List<String> companyNames = new ArrayList<>();
		for(MyInterns myinterns: myInternsList) {
			Internships intern = new Internships();
			intern = myinternsservice.getInternshipsByTitle(myinterns.getTitle());
			companyNames.add(myinternsservice.getCompanyName(intern.getCompanyID()));
			internships.add(intern);
		}
		mv.addObject("myInternsList", myInternsList);
		mv.addObject("companyNames",companyNames);
		mv.addObject("internships", internships);
		mv.setViewName("allinterns");
		return mv;
	}
	
	@GetMapping("addcompany")
	public ModelAndView addCompany() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addcompanies");
		return mv;
	}
	
	@PostMapping("/addcompany")
    public String addCompany(Model model, HttpServletRequest request) {
        Map<String, String> companyData = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            companyData.put(paramName, paramValue);
        }

        companyservice.processCompanyData(companyData);

        model.addAttribute("message", "Company added successfully!");

        return "redirect:/addcompany";
    }
}
