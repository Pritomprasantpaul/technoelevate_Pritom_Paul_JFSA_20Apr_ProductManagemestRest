package com.te.productmanagementrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.productmanagementrest.beans.ProductResponse;
import com.te.productmanagementrest.service.ProductService;
import com.te.productmanagementrest.beans.ProductBean;


@RestController
public class ProductController {
	
	@Autowired(required = false)
	private ProductService service;
	
	@GetMapping(path = "/getProduct", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ProductResponse getProductData(int id) {
		ProductBean infoBean = service.getProductData(id);
		ProductResponse response = new ProductResponse();
		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data found for id : " + id);
			response.setProductBean(infoBean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure");
			response.setDescription("Data not found for id : " + id);
		}
		return response;
	}
	
	@PostMapping(path = "/addProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ProductResponse addProductData(@RequestBody ProductBean infoBean) {
		ProductResponse response = new ProductResponse();

		if (service.addProduct(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data inserted Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Could not be inserted");
		}
		return response;
	}

	@PutMapping(path = "/updateProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ProductResponse updateProductResponse(@RequestBody ProductBean infoBean) {
		ProductResponse response = new ProductResponse();

		if (service.updateProduct(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Updated Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Could not be updated");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteProduct/{pid}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ProductResponse deleteProduct(@PathVariable int pid) {
		ProductResponse response = new ProductResponse();

		if (service.deleteProductData(pid)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Delete Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Not Exist");
		}
		return response;

	}//

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ProductResponse getAllProduct() {
		ProductResponse response = new ProductResponse();
		List<ProductBean> productBeans = service.getAllProduct();
		if (productBeans != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Found Sucessfully");
			response.setProductBeans(productBeans);
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Not Exist");
		}
		return response;
	}

}