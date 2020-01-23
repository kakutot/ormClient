package com.example.service;

import java.util.List;

import com.example.model.Department;
import com.example.model.beans.DepartmentBean;

public interface DepartmentService {
	
	List<Department> getAll();

	Department add(Department department);
	
	Department getDepartmentWithInner(DepartmentBean departmentBean);

	List<Department> getAll_IncludeCompany();
}