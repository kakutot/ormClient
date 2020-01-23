package com.example.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Company;
import com.example.model.Employee;
import com.example.repository.CompanyRepository;
import com.example.service.CompanyService;
import com.softserve.task.ormcore.session.ISession;
import com.softserve.task.ormcore.session.SessionFactory;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{
	
	private final CompanyRepository companyRepository;
	

	@Override
	public List<Company> getAll() throws SQLException, InterruptedException {
		ISession session = SessionFactory.getInstance().createSession();
		List<Company> list = session.selectAll(Company.class).build();
//		List<Company> list = companyRepository.findAll();
//		for (Company company : list) {
//			company.setEmployees(null);
//			company.setDepartments(null);
//		}
		return list;
	}
	
	@Override
	public List<Company> getAll_IncludeEmployee() throws InterruptedException, SQLException {
		ISession session = SessionFactory.getInstance().createSession();
		List<Company> list = session.selectAll(Company.class).include(Employee.class).build();
//		List<Company> list = companyRepository.findAll();
//		for (Company company : list) {
//			company.setEmployees(null);
//		}
		return list;
	}
	
	@Override
	public List<Company> getAll_IncludeDepartment() {
		List<Company> list = companyRepository.findAll();
		for (Company company : list) {
			company.setDepartments(null);
		}
		return list;
	}
	
	@Override
	public List<Company> getAll_IncludeEmployeeDepartment() {
		List<Company> list = companyRepository.findAll();
		for (Company company : list) {
			company.setEmployees(null);
			company.setDepartments(null);
		}
		return list;
	}

	@Override
	public Company add(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company getById(long id) {
		return companyRepository.findById(id).get();
	}
	
}