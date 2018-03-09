package com.ikbal.viewAndEditProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ikbal.createProject.dto.CreateProjectDTO;
import com.ikbal.viewAndEditProject.service.ViewAndEditProjectService;
@Controller
@RequestMapping("/")

public class ViewAndEditProjectController {
	
	@Autowired
	ViewAndEditProjectService viewandeditProjectService;

	public ViewAndEditProjectController() {
		System.out.println(this.getClass().getSimpleName() + "object created");
	}

	@RequestMapping(value = "/changeStatus.do", method = RequestMethod.POST)
	public ModelAndView viewandEditProjectController(CreateProjectDTO createprojectDTO) {
		
		System.out.println(" viewandEditProjectController is started");
		System.out.println(createprojectDTO);

		int temp = viewandeditProjectService.updateProjectStatus(createprojectDTO);

		System.out.println("viewandEditProjectController Method is Ended");
		return new  ModelAndView("viewProject.jsp");
	}

}
