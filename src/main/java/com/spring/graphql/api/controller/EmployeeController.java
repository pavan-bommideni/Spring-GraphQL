package com.spring.graphql.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphql.api.entity.Employee;
import com.spring.graphql.api.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	/* Get List of Employees with all the fields */
	@GetMapping("/employees")
	public List<Employee> getEmpList() {
		System.out.println("getMovieList invoked");
		return employeeService.getEmployees();
	}
}

