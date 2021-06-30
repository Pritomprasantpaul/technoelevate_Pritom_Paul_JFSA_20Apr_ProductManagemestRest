package com.te.productmanagementrest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.productmanagementrest.beans.ProductBean;

@Repository
public class ProductDAOHibernateImpl implements ProductDAO{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	@Override
	public ProductBean getProductData(int pid) {
		ProductBean productBean = em.find(ProductBean.class, pid);
		em.close();
		emf.close();
		return productBean;
	}

	@Override
	public boolean deleteProductData(int pid) {
		boolean isDeleted = false;
		try {
			et.begin();
			ProductBean productBean = em.find(ProductBean.class, pid);
			em.remove(productBean);
			et.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
		return isDeleted;
	}

	@Override
	public boolean addProduct(ProductBean productBean) {
		boolean isInserted = false;
		try {
			et.begin();
			em.persist(productBean);
			et.commit();
			isInserted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
		}
		return isInserted;
	}

	@Override
	public boolean updateProduct(ProductBean productBean) {
		boolean isUpdated = false;
		try {
			ProductBean bean = em.find(ProductBean.class, productBean.getPid());
			et.begin();
			
			if(bean.getMgDate() != null)
				bean.setMgDate(productBean.getMgDate());
			
			if(bean.getExDate() != null)
				bean.setExDate(productBean.getExDate());
			
			if(bean.getPname() != null && bean.getPname() != "")
				bean.setPname(productBean.getPname());
			
			if(bean.getPrice() >  0)
				bean.setPrice(productBean.getPrice());
			
			if(bean.getQuantity() > 0 )
				bean.setQuantity(productBean.getQuantity());
			
			et.commit();
			isUpdated = true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return isUpdated;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getAllProduct() {
		Query query = em.createQuery("from ProductBean");
		ArrayList<ProductBean> productBean = new ArrayList<ProductBean>();
		try {
			productBean = (ArrayList<ProductBean>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			productBean = null;
		}
		return productBean;
	}

}
