 package com.ikbal.createProject.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cimexa_practice_table")
public class CreateProjectDTO implements Serializable 
{
	@Id
	@GenericGenerator(name="anything",strategy="increment")
	@GeneratedValue(generator="anything")
	@Column(name="project_id")
	private int id;
	@Column(name="pname")
	private String pname;
	@Column(name="ptype")
	private String ptype;
	@Column(name="pcode")
	private String pcode;
	@Column(name="pdesc")
	private String pdesc;
	@Column(name="peta")
	private String peta;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="pdate")
	private Date pdate;
	@Column(name="pStatus")
	private String pstatus;
	
	

public CreateProjectDTO() {
System.out.println(this.getClass().getSimpleName()+"Created...!");
}

public String getPstatus() {
	return pstatus;
}

public void setPstatus(String pstatus) {
	this.pstatus = pstatus;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public String getPtype() {
	return ptype;
}

public void setPtype(String ptype) {
	this.ptype = ptype;
}

public String getPcode() {
	return pcode;
}

public void setPcode(String pcode) {
	this.pcode = pcode;
}

public String getPdesc() {
	return pdesc;
}

public void setPdesc(String pdesc) {
	this.pdesc = pdesc;
}

public String getPeta() {
	return peta;
}

public void setPeta(String peta) {
	this.peta = peta;
}

public Date getPdate() {
	return pdate;
}

public void setPdate(Date pdate) {
	this.pdate = pdate;
}

@Override
public String toString() {
	return "CreateProjectDTO [id=" + id + ", pname=" + pname + ", ptype=" + ptype + ", pcode=" + pcode + ", pdesc="
			+ pdesc + ", peta=" + peta + ", pdate=" + pdate + ", pstatus=" + pstatus + "]";
}






}
