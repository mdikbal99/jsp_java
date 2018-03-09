package com.ikbal.adminLogin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class AdminController {
    @Value("${userid}")
	private String userid;
    @Value("${password}")
	private String password;

	public AdminController() {
		System.out.println(this.getClass().getSimpleName() + "Login object created");

	}
	
	
	
	
    @RequestMapping(value="/login.do",method=RequestMethod.POST)
	public ModelAndView loginAdminController(AdminDTO dto) {
		System.out.println("loginAdminController method started");
		System.out.println(dto);
		
		System.out.println(userid + "\t" + password);
		
		if (dto.getUserid().equals(userid) && dto.getPassword().equals(password)) {
			System.out.println("admin login sucess");
			ModelAndView modelAndView3=new ModelAndView("/welcomeAdmin.jsp");
			return  modelAndView3;
		}
		System.out.println("login admin controller ended");
		ModelAndView modelAndView1=new ModelAndView("/login.jsp","loginFail","!wrong id or password entered !");
		return  modelAndView1;

	}
}
