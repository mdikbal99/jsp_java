package com.ikbal.createProject.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikbal.createProject.dto.CreateProjectDTO;
@Repository
public class CreateProjectDAO 
{
@Autowired
	private SessionFactory factory;
	public CreateProjectDAO() 
	{
		System.out.println(this.getClass().getSimpleName()+"Created...");
	}
	public void save(CreateProjectDTO createprojectDTO)
	{ 
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(createprojectDTO);
		try
		{
		tx.commit();
		}
		catch (HibernateException e) 
		{
			tx.rollback();
			e.printStackTrace();
		}
}
}