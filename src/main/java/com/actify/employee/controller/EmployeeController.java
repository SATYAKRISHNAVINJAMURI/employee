package com.actify.employee.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actify.employee.entity.Employee;
import com.actify.employee.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/")
public class EmployeeController {
	private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping(value={"hello",""})
	public String helloRequestHandler() {
		return "Heya! I'm up";
	}
	
	@GetMapping(value="listAllEmployees")
	public List<Employee> listAllEmployees() {
		try {
			List<Employee> empList = (List<Employee>) employeeRepository.findAll(); 
			return empList != null ? empList : null;
		}catch (DataAccessException e) {
			LOGGER.error("Unable to fetch users list");
			LOGGER.error(e.getMessage());
		}
		return null;

	}
	
	@GetMapping(value="getEmployeeData/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		try {
			Optional<Employee> emp = employeeRepository.findById(id);
			return emp.isPresent() ? emp.get() : null;
		}catch (DataAccessException e) {
			LOGGER.error("Unable to fetch user details with id:{}",id);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@DeleteMapping(value="deleteEmployee/{id}")
	public 	String deleteEmployee(@PathVariable Long id) {
		try {
			employeeRepository.deleteById(id);
		}catch (DataAccessException e) {
			LOGGER.error("Unable to delete user with Id:{}", id);
			LOGGER.error(e.getMessage());
			return "Unable to delete the user with Id:" + id;
		}
		return "User with Id:" + id + " deleted";
	}
}