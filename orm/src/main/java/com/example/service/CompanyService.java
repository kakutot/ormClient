package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Company;

public interface CompanyService {

	List<Company> getAll() throws SQLException, InterruptedException;

	Company add(Company company);
	
	Company getById(long id);

	List<Company> getAll_IncludeEmployee() throws InterruptedException, SQLException;

	List<Company> getAll_IncludeDepartment();

	List<Company> getAll_IncludeEmployeeDepartment();

}
