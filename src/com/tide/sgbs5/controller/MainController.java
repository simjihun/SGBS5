package com.tide.sgbs5.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	@RequestMapping(value="/main", method=RequestMethod.GET) 
	public ModelAndView showMain(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException
	{	
		System.out.println("MainController connect");
		request.setCharacterEncoding("UTF-8");		
		ModelAndView mv = new ModelAndView("main");
		return mv;
	}

}
