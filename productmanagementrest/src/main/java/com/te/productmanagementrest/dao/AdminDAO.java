package com.te.productmanagementrest.dao;

import com.te.productmanagementrest.beans.AdminBean;

public interface AdminDAO {

	public AdminBean authenticate(int aid, String password);
	
}
