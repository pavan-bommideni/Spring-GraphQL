package com.spring.graphql.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.graphql.api.entity.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
