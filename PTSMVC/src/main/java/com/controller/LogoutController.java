package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	String message = "You have logged out!";
	 
	@RequestMapping("/logout")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		
		//retire token
		
		ModelAndView mv = new ModelAndView("logout");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
}