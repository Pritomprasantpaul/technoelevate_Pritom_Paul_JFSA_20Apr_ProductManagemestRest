package com.te.productmanagementrest.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.te.productmanagementrest.beans.AdminBean;
import com.te.productmanagementrest.dao.AdminDAO;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO dao;
	
	@Override
	public AdminBean authenticate(int aid, String password) {
		
		if(aid<=0)
			return null;
		else
			return dao.authenticate(aid, password);
	}

}
