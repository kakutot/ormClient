package com.example.service;

import java.util.List;

import com.example.model.Employee;
import com.example.model.beans.EmployeeBean;

public interface EmployeeService {
	
	List<Employee> getAll();

	Employee add(Employee employee);
	
	Employee getEmployeeWithInner(EmployeeBean employeeBean);

	List<Employee> getAll_IncludeCompany();
}
