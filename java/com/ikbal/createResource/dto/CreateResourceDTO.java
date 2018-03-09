package com.ikbal.createResource.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.ikbal.createResource.services.CreateResourceServices;



@Entity
@Table(name="Resource_Table")
public class CreateResourceDTO implements Serializable
{ 
	
	@Id
	@GenericGenerator(name="resource",strategy="increment")
	@GeneratedValue(generator="resource")
	@Column(name="resource_id")
	private int rid;
	@Column(name="resource_Name")
	private String rname;
	@Column(name="resource_designation")
	private String designation;
	@Column(name="emp_No")
	private String ecode;
	@Column(name="project_Name")
	private String pname;
	@Column(name="resource_Email")
	private String email;
	@Column(name="manager_Email")
	private String memail;
	@Column(name="resource_password")
	private String rpassword; 
	
	
	
	public CreateResourceDTO() 
	{
	System.out.println(this.getClass().getSimpleName()+"Created...");
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getEcode() {
		return ecode;
	}


	public void setEcode(String ecode) {
		this.ecode = ecode;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getRpassword() {
		return rpassword;
	}


	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}


	@Override
	public String toString() {
		return "CreateResourceDTO [rid=" + rid + ", rname=" + rname + ", designation=" + designation + ", ecode="
				+ ecode + ", pname=" + pname + ", email=" + email + ", memail=" + memail + ", rpassword=" + rpassword
				+ "]";
	}


}
