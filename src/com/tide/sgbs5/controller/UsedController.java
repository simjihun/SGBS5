package com.tide.sgbs5.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tide.sgbs5.model.UsedCurrentDTO;
import com.tide.sgbs5.service.UsedCurrentService;


@Controller
public class UsedController {
	
	@Resource(name="usedCurrentService")
	private UsedCurrentService usedCurrentService;
	
	
	@RequestMapping(value="/used/usedCurrent", method=RequestMethod.GET) 
	public ModelAndView showUsedCurrent(UsedCurrentDTO usedCurrentDto, HttpSession session, HttpServletRequest request, HttpServletResponse response) 
			throws IOException
	{
		request.setCharacterEncoding("UTF-8");	
		ModelAndView mv = new ModelAndView("usedCurrent");
		System.out.println("경로 : UsedController -- GET 접속 ");		
		return mv;
	}
	
	@RequestMapping(value="/used/usedCurrent", method=RequestMethod.POST) 
	public ModelAndView getUsedCurrent(UsedCurrentDTO usedCurrentDto, HttpSession session, HttpServletRequest request, 
			HttpServletResponse response, String rsd_id) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
//		usedCurrentDto.setRsd_id("10050" + 	usedCurrentDto.getAddr1() + 	usedCurrentDto.getAddr2());	
		ModelAndView mv = new ModelAndView("usedCurrent");
		System.out.println("경로 : UsedController -- POST 접속 ");		
		mv.addObject("usedShow", usedCurrentService.usedShow(usedCurrentDto));
		return mv;
	}

}
