package com.backend.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.DAO.PracticeDAO;
import com.backend.demo.VO.Employees;

@RestController
@RequestMapping(path = "/backend")
public class MainController {

	@Autowired
	private PracticeDAO dao;
	
	@GetMapping(path = "/", produces = "application/json")
	public Employees getEmployees() {
		return dao.getAllEmployees();
	}
}
