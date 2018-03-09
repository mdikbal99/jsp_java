package com.ikbal.createResource.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.ikbal.createResource.dao.CreateResourceDAO;
import com.ikbal.createResource.dto.CreateResourceDTO;

@Service
public class CreateResourceServices {
	@Autowired
	private CreateResourceDAO createResourceDAO;
	@Autowired
	private SimpleMailMessage message;
	@Autowired
	private JavaMailSenderImpl mailSender;

	public CreateResourceServices() {
		System.out.println(this.getClass().getSimpleName() + "Created...");
	}

/*	public void genaratepassword(CreateResourceDTO createResourceDTO) {
		System.out.println("generate password method started ");
		String values = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_=+-/.?<>";

		Random rndm_method = new Random();
		char[] password = new char[8];
		for (int i = 0; i < 8; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
		}
	String s1= new String(password);
	createResourceDTO.setRpassword(s1);
	System.out.println(createResourceDTO);
		System.out.println("generate password method ended ");
		//return createResourceDAO.genaratepasswordDAO(createResourceDTO);

	}*/

	public void createResourceServices(CreateResourceDTO createResourceDTO) {
		System.out.println("Create Resource Srevice Started.. ");

		message.setTo("umeshmg51@gmail.com");
		message.setSubject("Toufique's Pratice Project");
		message.setText(
				"Congratulations!,You became a Part of Cimexa \n\n this to inform you are assign for my project Cimexa \n\n ur user nme is :"
						+ createResourceDTO.getEmail() + "and passWord is : " + createResourceDTO.getRpassword());

		mailSender.send(message);

		createResourceDAO.saveResourceDetails(createResourceDTO);

		System.out.println("Create Resource Srevice Ended.. ");
	}

	public void updateservice(CreateResourceDTO createResourceDTO) {
		System.out.println("update service method started inside UpdateResourceService");

		createResourceDAO.update(createResourceDTO);

		System.out.println("update service method ended inside UpdateResourceService");

	}

	public List<CreateResourceDTO> viewResourceService() {
		return createResourceDAO.viewResourceDAO();
	}

	public List<String> getProjectNameService() {
		return createResourceDAO.getProjectNameDao();

	}

	
}
