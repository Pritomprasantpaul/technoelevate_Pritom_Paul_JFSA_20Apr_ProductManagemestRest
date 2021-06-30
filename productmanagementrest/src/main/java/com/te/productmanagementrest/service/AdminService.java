package com.te.productmanagementrest.service;

import com.te.productmanagementrest.beans.AdminBean;

public interface AdminService {

	public AdminBean authenticate(int aid, String password);
}
