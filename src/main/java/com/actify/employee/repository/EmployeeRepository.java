package com.actify.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.actify.employee.entity.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
