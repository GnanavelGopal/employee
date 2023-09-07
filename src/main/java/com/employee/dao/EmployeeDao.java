package com.employee.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.controller.EmployeeController;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	public static Logger log = Logger.getLogger(EmployeeDao.class);
	@Autowired
	EmployeeRepository er;

	public String setValue(Employee employee) {
		er.save(employee);
		return "save";
	}

	public String setAllValue(List<Employee> employees) {
		er.saveAll(employees);
		return "save All";
	}

	public List<Employee> getAllValue() {
		PropertyConfigurator.configure("employee.properties");
		log.info(er.findAll());
		return er.findAll();
	}
	
}
