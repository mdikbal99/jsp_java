package com.ikbal.viewAndEditProject.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikbal.createProject.dto.CreateProjectDTO;

@Repository
public class ViewAndEditProjectDAO {

	@Autowired
	private SessionFactory factory;

	public ViewAndEditProjectDAO() {
		System.out.println(this.getClass().getSimpleName() + "created");
	}

	public int updateProjectStatus(CreateProjectDTO createprojectDTO) {
		System.out.println("updateStatus method isside editDAO created");

		Session session = factory.openSession();
		CreateProjectDTO cdto = (CreateProjectDTO) session.load(CreateProjectDTO.class, createprojectDTO.getId());

		if (createprojectDTO.getPstatus().equalsIgnoreCase("active")) {
			cdto.setPstatus("Deactive");
		} else {
			cdto.setPstatus("Active");
		}

		Transaction tx = session.beginTransaction();
		session.save(cdto);
		try {
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}

		return 0;
	}

}
