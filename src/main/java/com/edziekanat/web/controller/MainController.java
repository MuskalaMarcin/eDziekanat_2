package com.edziekanat.web.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "eDziekanat");
		model.addObject("message", "Strona domyslna!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "eDziekanat - administrator strona glowna");
		model.addObject("message", "Strona tylko dla administratorow!");
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping(value = "/student**", method = RequestMethod.GET)
	public ModelAndView studentPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "eDziekanat - student strona glowna");
		model.addObject("message", "Strona tylko dla studentow");
		model.setViewName("student");

		return model;

	}
	
	@RequestMapping(value = "/lecturer**", method = RequestMethod.GET)
	public ModelAndView lecturerPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "eDziekanat - wykladowca strona glowna");
		model.addObject("message", "Strona tylko dla wykladowcow");
		model.setViewName("lecturer");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Bledny login lub haslo!");
		}

		if (logout != null) {
			model.addObject("msg", "Zostales wylogowany.");
		}
		model.setViewName("login");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}

}