package com.spring.graphql.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.graphql.api.entity.Employee;
import com.spring.graphql.api.repository.EmployeeRespository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRespository employeeRespository;
	
	public List<Employee> getEmployees(){
		return employeeRespository.findAll();
	}

}
