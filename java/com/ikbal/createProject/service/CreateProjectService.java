package com.ikbal.createProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikbal.createProject.dao.CreateProjectDAO;
import com.ikbal.createProject.dto.CreateProjectDTO;

@Service
public class CreateProjectService 
{
		@Autowired
		private CreateProjectDAO createProjectDAO;
		
	public CreateProjectService() 
	{
	System.out.println(this.getClass().getSimpleName()+"Created...");
	}
	public void createCreateProjectService(CreateProjectDTO createprojectDTO)
	{
		System.out.println("CreateProject method  is Running");
		createProjectDAO.save(createprojectDTO);
		
		System.out.println("Create Service is Ended");
	}
	
}
