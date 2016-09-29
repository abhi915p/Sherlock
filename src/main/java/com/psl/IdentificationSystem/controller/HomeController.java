package com.psl.IdentificationSystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.psl.IdentificationSystem.entity.Citizen;
import com.psl.IdentificationSystem.entity.CreditHistory;
import com.psl.IdentificationSystem.entity.Criminal;
import com.psl.IdentificationSystem.service.CitizenService;
import com.psl.IdentificationSystem.service.CreditHistoryService;
import com.psl.IdentificationSystem.service.CriminalDetailsService;

@Controller
public class HomeController {

	@Autowired
	CitizenService c_service;
	
	@Autowired
	CriminalDetailsService cd_service;
	
	@Autowired
	CreditHistoryService ch_service;
	
	private XmlWebApplicationContext context;
	
	public void initializeContext(HttpServletRequest request){
		System.out.println("file initialized...");
		context = new  XmlWebApplicationContext();
		context.setConfigLocation("/WEB-INF/SpringDispatcher-servlet.xml");
		context.setServletContext(request.getSession().getServletContext());
		context.refresh();
	//	service = (DonorService)context.getBean("service");
	}
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/citizen",method=RequestMethod.GET)
	public ModelAndView getCitizenDetails(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam String id){
		//System.out.println(country+" "+id);
		initializeContext(request);
		c_service=(CitizenService)context.getBean("citizen_service");
		String country="in";
		Citizen citizen=c_service.getCitizenDetails(country,id);
		
		model.addAttribute("citizen",citizen);
		
		System.out.println(
				
				"UIN :"+citizen.getUIN()+
				"\nName :"+citizen.getF_name()+" "+citizen.getL_name()+
				"\nCountry :"+citizen.getCountry()+
				"\nDOB :"+citizen.getDob()+
				"\nHeight :"+citizen.getHeight()+
				"\nWeight :"+citizen.getWeight()+
				"\nSkin Color :"+citizen.getSkin_color()+
				"\nEmail :"+citizen.getEmail()
				);
		
		return new ModelAndView("citizen");
	}
	
	@RequestMapping(value="/criminal",method=RequestMethod.GET)
	public ModelAndView getCriminalDetails(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam String id){
		
		String country="in";
		System.out.println(country);
				
		
		initializeContext(request);
		
		cd_service=(CriminalDetailsService)context.getBean("criminal_details_service");
		
		List<Criminal> criminal=cd_service.getCriminalDetails(country, id);
		
		model.addAttribute("criminal",criminal);		
		
		for(Criminal crime:criminal)
			System.out.println(crime.getDescription());
		
		return new ModelAndView("criminal_record");
	}
	
	@RequestMapping(value="/credit_history",method=RequestMethod.GET)
	public ModelAndView getCreditHistoryDetails(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam String id){
		
		String country="in";
		System.out.println(country);
		
		
		initializeContext(request);
		ch_service=(CreditHistoryService)context.getBean("credit_history_service");
		
		List<CreditHistory> credit_history=ch_service.getCreditDetails(country, id);
		
		model.addAttribute("credit_history",credit_history);
		
		for(CreditHistory cd: credit_history)
			System.out.println(cd.getBankName());
		
		return new ModelAndView("credit_history");
	}
}
