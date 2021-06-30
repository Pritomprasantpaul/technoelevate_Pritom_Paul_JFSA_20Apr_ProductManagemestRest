package com.te.productmanagementrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.productmanagementrest.beans.ProductBean;
import com.te.productmanagementrest.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO pdao;
	
	@Override
	public ProductBean getProductData(int pid) {
		if(pid <= 0)
			return null;
		
		return pdao.getProductData(pid);
	}

	@Override
	public boolean deleteProductData(int pid) {
		return pdao.deleteProductData(pid);
	}

	@Override
	public boolean addProduct(ProductBean productBean) {
		return pdao.addProduct(productBean);
	}

	@Override
	public boolean updateProduct(ProductBean productBean) {
		return pdao.updateProduct(productBean);
	}

	@Override
	public List<ProductBean> getAllProduct() {
		return pdao.getAllProduct();
	}

}
