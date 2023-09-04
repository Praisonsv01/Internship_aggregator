package com.spring.reckathon.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.reckathon.model.Company;
import com.spring.reckathon.model.User;
import com.spring.reckathon.service.CompanyService;
import com.spring.reckathon.service.UserService;

@Controller
public class UserController {
	
	private User currentUser;
	
	@Autowired
	UserService service;
	
	@Autowired
	CompanyService companyService;

	@GetMapping("/home")
	public String homepage() {
		return "home";
	}
	
	@GetMapping("/login")
	public String method() {
		return "userlogin";
	}

	@GetMapping("/signup")
	public String method2() {
		return "usersignup";
	}
	
	@GetMapping("user-dashboard")
	public ModelAndView getUserDashboard(HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();

		List<Company> companies = companyService.getAllCompanies();
		mv.addObject("companies", companies);
		mv.addObject("user", currentUser);
		mv.setViewName("userdashboard");
		return mv; 
	}
	
	@PostMapping("login_into")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {

			User user = service.login(email, password);
			List<Company> companies = companyService.getAllCompanies();
			currentUser = user;
			mv.addObject("companies", companies);
			mv.addObject("user", user);
			mv.setViewName("userdashboard");
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			return mv;

		} catch (Exception e) {
			mv.setViewName("userlogin");
			mv.addObject("Message", "Login failed");
			return mv;
		}

	}
	
	@PostMapping("signup_into")
	public ModelAndView signup(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("name") String name, @RequestParam("phoneno") String phoneno) {
		ModelAndView mv = new ModelAndView();
		try {

			User user = service.signup(email, password, name, phoneno);
			mv.setViewName("userlogin");
			return mv;

		} catch (Exception e) {

			mv.setViewName("usersignup");
			mv.addObject("Message", "Signup failed");
			return mv;
		}

	}

}