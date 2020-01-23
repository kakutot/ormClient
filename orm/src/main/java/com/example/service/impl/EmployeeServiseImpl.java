package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Company;
import com.example.model.Employee;
import com.example.model.beans.EmployeeBean;
import com.example.repository.EmployeeRepository;
import com.example.service.CompanyService;
import com.example.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiseImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	private final CompanyService companyService;

	@Override
	public List<Employee> getAll() {
		List<Employee> list = employeeRepository.findAll();
		for (Employee e : list) {
			e.setCompany(null);
		}
		return list;
	}
	
	@Override
	public List<Employee> getAll_IncludeCompany() {
		List<Employee> list = employeeRepository.findAll();
		for (Employee e : list) {
			Company company = e.getCompany();
			company.setEmployees(null);
			e.setCompany(company);
		}
		return list;
	}

	@Override
	public Employee add(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee getEmployeeWithInner(EmployeeBean employeeBean) {
		Employee employee = new Employee();
		employee.setId(employeeBean.getId());
		employee.setName(employeeBean.getName());
		Company company = companyService.getById(employeeBean.getCompanyId());
		company.setEmployees(null);
		company.setDepartments(null);
		employee.setCompany(company);
		return employee;
	}

}
