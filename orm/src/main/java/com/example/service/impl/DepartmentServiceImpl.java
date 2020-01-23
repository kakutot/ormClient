package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Company;
import com.example.model.Department;
import com.example.model.beans.DepartmentBean;
import com.example.repository.DepartmentRepository;
import com.example.service.CompanyService;
import com.example.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;
	
	private final CompanyService companyService;

	@Override
	public List<Department> getAll() {
		List<Department> list = departmentRepository.findAll();
		for (Department e : list) {
			e.setCompany(null);
		}
		return list;
	}
	
	@Override
	public List<Department> getAll_IncludeCompany() {
		List<Department> list = departmentRepository.findAll();
		for (Department e : list) {
			Company company = e.getCompany();
			company.setEmployees(null);
			e.setCompany(company);
		}
		return list;
	}

	@Override
	public Department add(Department department) {
		return departmentRepository.save(department);
	}
	
	@Override
	public Department getDepartmentWithInner(DepartmentBean departmentBean) {
		Department department = new Department();
		department.setId(departmentBean.getId());
		department.setCity(departmentBean.getCity());
		department.setAddress(departmentBean.getAddress());
		Company company = companyService.getById(departmentBean.getCompanyId());
		company.setEmployees(null);
		company.setDepartments(null);
		department.setCompany(company);
		return department;
	}

}
