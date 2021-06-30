package com.te.productmanagementrest.dao;

import java.util.List;

import com.te.productmanagementrest.beans.ProductBean;

public interface ProductDAO {

	public ProductBean getProductData(int pid);
	
	public boolean deleteProductData(int pid);
	
	public boolean addProduct(ProductBean productBean);
	
	public boolean updateProduct(ProductBean productBean);
	
	public List<ProductBean> getAllProduct();
	
}
