package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.beans.EmployeeBean;
import com.example.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@GetMapping("/")
	@ApiOperation(value = "Gets all the employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAll();
	}
	
	@GetMapping("/include_company")
	@ApiOperation(value = "Gets all the employees include company")
	public List<Employee> getAllEmployees_includeCompany() {
		return employeeService.getAll_IncludeCompany();
	}

	@PostMapping("/")
	@ApiOperation(value = "Adds a new employee", response = Employee.class)
	public Employee addEmployee(@RequestBody EmployeeBean employeeBean) {
		return employeeService.getEmployeeWithInner(employeeBean);
	}

}
