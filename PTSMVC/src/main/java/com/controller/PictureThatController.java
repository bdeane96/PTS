package com.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class PictureThatController {
 
	@RequestMapping("/PictureThat")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "User") String name) {
		
		//get token
		//retrieve images
		
		ModelAndView mv = new ModelAndView("picturethat");
		mv.addObject("name", name);
		return mv;
	}
}