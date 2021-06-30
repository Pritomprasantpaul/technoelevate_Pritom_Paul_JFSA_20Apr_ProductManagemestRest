package com.te.productmanagementrest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import com.te.productmanagementrest.Excep.AdminException;
import com.te.productmanagementrest.beans.AdminBean;

@Service
public class AdminDAOHibernateImpl implements AdminDAO{

	@Override
	public AdminBean authenticate(int aid, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager em = emf.createEntityManager();
		
		AdminBean adminBean = em.find(AdminBean.class, aid);
		
		if (adminBean != null) {
			if (adminBean.getPassword().equals(password)) {
				return adminBean;
			} else {
				throw new AdminException("Password is Wrong...");
			}
		} else {
			throw new AdminException("Invalid ID");
		}
	}

}
