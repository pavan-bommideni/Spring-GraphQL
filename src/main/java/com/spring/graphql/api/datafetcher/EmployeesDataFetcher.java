package com.spring.graphql.api.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphql.api.entity.Employee;
import com.spring.graphql.api.repository.EmployeeRespository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class EmployeesDataFetcher  implements DataFetcher<List<Employee>> {
	@Autowired
	private EmployeeRespository repository;

	@Override
	public List<Employee> get(DataFetchingEnvironment environment) {
		System.out.println("EmployeesDataFetcher invoked");
		return repository.findAll();
	}
}
