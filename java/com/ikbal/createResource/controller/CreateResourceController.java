package com.ikbal.createResource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ikbal.createProject.dto.CreateProjectDTO;
import com.ikbal.createResource.dto.CreateResourceDTO;
import com.ikbal.createResource.services.CreateResourceServices;
import com.ikbal.util.PasswordGenerator;

@Controller
@RequestMapping("/")
public class CreateResourceController {
	@Autowired
	private CreateResourceServices createResourceServices;
	@Autowired
	private PasswordGenerator pg;

	public CreateResourceController() {
		System.out.println(this.getClass().getSimpleName() + "Created...");
	}

	@RequestMapping(value = "/resourceSave.do", method = RequestMethod.POST)
	public ModelAndView createResourceController(CreateResourceDTO createResourceDTO) {
		System.out.println("CreateResourceController is Started..");
		// createResourceServices.genaratepassword(createResourceDTO);
		String s = pg.auto_Password();
		createResourceDTO.setRpassword(s);
		createResourceServices.createResourceServices(createResourceDTO);

		System.out.println("CreateResourceController is Endted..");
		ModelAndView modelandviewResource = new ModelAndView("welcomeAdmin.jsp", "resorceCreatemsg1",
				"resource saved!success");
		return modelandviewResource;
	}
	
	/*@RequestMapping(value="viewResource.do")
	public ModelAndView viewResource(){
		System.out.println("view resource staarted");
		List<CreateResourceDTO> viewRes=createResourceServices.viewResourceService();
		System.out.println("view resource endded");
		ModelAndView modelAndView=new ModelAndView("viewResource.jsp","view",viewRes);
return modelAndView;		
	}*/

	@RequestMapping(value = "createResource.do")
	public ModelAndView getProjectName() {
		System.out.println("getProjectName() is Started..");
		List<String> crs = createResourceServices.getProjectNameService();
		System.out.println("getProjectName() is Endted..");
		ModelAndView modelandviewResource = new ModelAndView("createResource.jsp", "l1", crs);
		return modelandviewResource;
	}

	@RequestMapping(value = "/editResource.do", method = RequestMethod.POST)
	public ModelAndView editController(CreateResourceDTO createResourceDTO) {
		System.out.println("UpdateResource.updateController method started");
		System.out.println("UpdateResource.updateController method ended");

		return new ModelAndView("updateResource.jsp", "edit", createResourceDTO);
	}

	@RequestMapping(value = "updateResource.do", method = RequestMethod.POST)
	public ModelAndView updateController(HttpServletRequest req, CreateResourceDTO createResourceDTO) {
		System.out.println("updateController method started inside Resourcecontroller");

		System.out.println("Idin con" + createResourceDTO);
		// int id=Integer.parseInt(req.getParameter("rid"));
		createResourceServices.updateservice(createResourceDTO);

		System.out.println("updateController method started inside ResourceDAO");
		return new ModelAndView("welcomeAdmin.jsp", "resorceupdatemsg", "succesfully updatetd resource data");

	}

}
