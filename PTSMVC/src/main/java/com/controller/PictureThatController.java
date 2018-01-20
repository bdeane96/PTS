package com.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.data.GoogleUserProfile;
import com.data.PicasaWebService;
 
@Controller
public class PictureThatController {
 
	@RequestMapping("/PictureThat")
	public ModelAndView showMessage(
			@RequestParam(value = "token", required = false, defaultValue = "User") String token, String name, String id) {
		
		GoogleUserProfile gop = new GoogleUserProfile(id, name, token);
		PicasaWebService pwa = new PicasaWebService(gop);
		//get token
		//retrieve images
		System.out.println(name +" " + token);
		ModelAndView mv = new ModelAndView("picturethat");
		mv.addObject("name", name);
		return mv;
	}
}