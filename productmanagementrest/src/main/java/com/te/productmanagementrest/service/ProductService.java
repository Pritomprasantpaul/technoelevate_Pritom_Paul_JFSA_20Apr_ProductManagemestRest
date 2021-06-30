package com.te.productmanagementrest.service;

import java.util.List;

import com.te.productmanagementrest.beans.ProductBean;

public interface ProductService {

	public ProductBean getProductData(int pid);
	
	public boolean deleteProductData(int pid);
	
	public boolean addProduct(ProductBean productBean);
	
	public boolean updateProduct(ProductBean productBean);
	
	public List<ProductBean> getAllProduct();
	
}
