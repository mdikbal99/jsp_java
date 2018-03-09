package com.ikbal.createProject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ikbal.createProject.service.CreateProjectService;
import com.ikbal.createProject.dto.CreateProjectDTO;

@Controller
@RequestMapping("/")
public class CreateProjectController 
{
	
	@Autowired
	private CreateProjectService createProjectService;
	public CreateProjectController()
		{
		System.out.println(this.getClass().getSimpleName()+"Created...");	
        }
	@InitBinder
	public void intitBinder(WebDataBinder webDataBinder){
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		
	}
	@RequestMapping(value="/createProject.do",method=RequestMethod.POST)
	public ModelAndView createAccountController(CreateProjectDTO createprojectDTO)
	{
		System.out.println(" Controll is inside Account method");
		System.out.println(createprojectDTO);
	//	ModelAndView modelAndView=new ModelAndView("/Response.jsp");
		
		createProjectService.createCreateProjectService(createprojectDTO);
		
		System.out.println("Create Account Controller Method is Ended");
		return new  ModelAndView("welcomeAdmin.jsp","msg1","create project Success");
	}
	
	
	
	
}
