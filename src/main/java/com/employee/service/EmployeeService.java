package com.employee.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.controller.EmployeeController;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.exception.LessSalaryException;

@Service
public class EmployeeService {
	public static Logger log = Logger.getLogger(EmployeeService.class);
	@Autowired
	EmployeeDao ed;

	public String setValue(Employee employee) {
		return ed.setValue(employee);
	}

	public String setAllValue(List<Employee> employees) throws LessSalaryException {
		List<Employee> e=employees.stream().filter(x->x.getSalary()>=75000).toList();
		if(e.isEmpty()) {
			throw new LessSalaryException("Less Salary");
		}
		else {
			return ed.setAllValue(e);
		}
		
	}

	public List<Employee> getAllValue() {
		PropertyConfigurator.configure("employee.properties");
		log.info(ed.getAllValue());
		return ed.getAllValue();
	}
	
}
