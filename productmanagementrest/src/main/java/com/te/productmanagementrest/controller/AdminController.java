package com.te.productmanagementrest.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.productmanagementrest.service.AdminService;

@RestController
public class AdminController {

	@Autowired(required = false)
	private AdminService service;
	
//	@GetMapping(path = "/getAdmin", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
}
