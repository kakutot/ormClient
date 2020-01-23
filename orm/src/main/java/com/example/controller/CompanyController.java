package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Company;
import com.example.model.beans.CompanyBean;
import com.example.service.CompanyService;
import com.softserve.task.ormcore.OrmFacade;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

	private final CompanyService companyService;
	
	@PostConstruct
	public void init() {
		OrmFacade ormFacade = new OrmFacade();
        ormFacade.initOrm();
	}

	@GetMapping("/")
	@ApiOperation(value = "Gets all the companies")
	public List<Company> getAllCompanies() {
		return companyService.getAll();
	}
	
	@GetMapping("/include_employee")
	@ApiOperation(value = "Gets all the companies include employee inner entity")
	public List<Company> getAllCompanies_includeEmployee() throws InterruptedException, SQLException {
		return companyService.getAll_IncludeEmployee();
	}
	
	@GetMapping("/include_departmant")
	@ApiOperation(value = "Gets all the companies include department inner entity")
	public List<Company> getAllCompanies_includeDepartment() {
		return companyService.getAll_IncludeDepartment();
	}
	
	@GetMapping("/include_employee_departmant")
	@ApiOperation(value = "Gets all the companies include employee and department inner entities")
	public List<Company> getAllCompanies_includeEmployeeDepartment() {
		return companyService.getAll_IncludeEmployeeDepartment();
	}

	@PostMapping("/")
	@ApiOperation(value = "Adds a new company", response = Company.class)
	public Company addCompany(@RequestBody CompanyBean companybean) {
		Company company = new Company();
		company.setId(companybean.getId());
		company.setName(companybean.getName());
		company.setCreatedAt(companybean.getCreatedAt());
		return companyService.add(company);
	}

}
