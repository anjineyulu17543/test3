package com.cglia.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.ems.dao.EmployeeDao;
import com.cglia.ems.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;

	@Override
	public Integer save(Employee employee) {
		Integer id = dao.save(employee);
		return id;
	}

	@Override
	public Employee getById(Integer id) {
		Employee emp = dao.getById(id);
		return emp;
	}

	@Override
	public int update(Employee employee) {
		int count = dao.update(employee);
		return count;
	}

	@Override
	public int deleteById(Integer id) {
		int count = dao.deleteById(id);
		return count;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> empList = dao.getAll();
		return empList;
	}

}
