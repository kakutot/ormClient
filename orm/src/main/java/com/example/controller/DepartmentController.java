package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Department;
import com.example.model.beans.DepartmentBean;
import com.example.service.DepartmentService;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	@GetMapping("/")
	@ApiOperation(value = "Gets all the departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAll();
	}
	
	@GetMapping("/include_company")
	@ApiOperation(value = "Gets all the departments include company")
	public List<Department> getAllDepartments_includeCompany() {
		return departmentService.getAll_IncludeCompany();
	}

	@PostMapping("/")
	@ApiOperation(value = "Adds a new department", response = Department.class)
	public Department addDepartment(@RequestBody DepartmentBean departmentBean) {
		return departmentService.getDepartmentWithInner(departmentBean);
	}

}
