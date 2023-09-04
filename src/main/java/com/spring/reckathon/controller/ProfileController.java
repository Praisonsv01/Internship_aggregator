package com.spring.reckathon.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.reckathon.model.Education;
import com.spring.reckathon.model.User;
import com.spring.reckathon.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	ProfileService service;

	@GetMapping("profile")
	public ModelAndView getProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		User user = service.ShowProfile((String)session.getAttribute("email"));

		mv.addObject("user", user);

		return mv;
	}

	@PostMapping("updatepassword")
	public String updatePassword(@RequestParam("password") String password, HttpSession session) {
		service.changePassword(password, session.getAttribute("email").toString());
		return "redirect:/profile";
	}

	@PostMapping("updatename")
	public String updateName(@RequestParam("name") String name, HttpSession session) {
		service.changeName(name, session.getAttribute("email").toString());
		return "redirect:/profile";
	}

	@PostMapping("updatephoneno")
	public String updatePhoneno(@RequestParam("phoneno") String phoneno, HttpSession session) {
		service.changePhoneno(phoneno, session.getAttribute("email").toString());
		return "redirect:/profile";
	}
	
	@GetMapping("education-details")
	public ModelAndView getEducation(HttpSession session) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<Education> educationList = service.getEducationList((String)session.getAttribute("email"));
		mv.addObject("educationList", educationList);
		mv.setViewName("education");
		return mv;
	}
	
	@GetMapping("addeducation")
	public String getaddEducation() {
		return "addeducation";
	}
	
	@PostMapping("addeducation")
	public String postaddEducation(HttpSession session,
            @RequestParam("degree") String degree,
            @RequestParam("fieldOfStudy") String fieldOfStudy,
            @RequestParam("institute") String institute,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("percentage") String percentage) {
		String email = (String) session.getAttribute("email");

		service.addEducation(email, degree, fieldOfStudy, institute, startDate, endDate, percentage);

		return "education";
	}

	@PostMapping("updatedegree")
	public String updatedegree(@RequestParam("degree") String degree, @RequestParam("courseId") int courseId, HttpSession session) {
	    service.updatedegree(degree, courseId, session.getAttribute("email").toString());
	    return "redirect:/education-details";
	}

	@PostMapping("updateFieldOfStudy")
	public String updateFieldOfStudy(@RequestParam("fieldOfStudy") String fieldOfStudy, @RequestParam("courseId") int courseId, HttpSession session) {
	    service.updateFieldOfStudy(fieldOfStudy, courseId, session.getAttribute("email").toString());
	    return "redirect:/education-details";
	}

	@PostMapping("updateInstitute")
	public String updateInstitute(@RequestParam("institute") String institute, @RequestParam("courseId") int courseId, HttpSession session) {
	    service.updateInstitute(institute, courseId, session.getAttribute("email").toString());
	    return "redirect:/education-details";
	}

	@PostMapping("updateStartDate")
	public String updateStartDate(@RequestParam("startDate") String startDate, @RequestParam("courseId") int courseId, HttpSession session) {
	    service.updateStartDate(startDate, courseId, session.getAttribute("email").toString());
	    return "redirect:/education-details";
	}

	@PostMapping("updateEndDate")
	public String updateEndDate(@RequestParam("endDate") String endDate, @RequestParam("courseId") int courseId, HttpSession session) {
	    service.updateEndDate(endDate, courseId, session.getAttribute("email").toString());
	    return "redirect:/education-details";
	}

	@PostMapping("updatePercentage")
	public String updatePercentage(@RequestParam("percentage") String percentage, @RequestParam("courseId") int courseId, HttpSession session) {
	    service.updatePercentage(percentage, courseId, session.getAttribute("email").toString());
	    return "redirect:/education-details";
	}
}
