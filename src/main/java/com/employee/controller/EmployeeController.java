package com.employee.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.entity.Employee;
import com.employee.exception.LessSalaryException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	public static Logger log = Logger.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService es;

	@PostMapping(value = "/setValue")
	public String setValue(@RequestBody Employee employee) {
		return es.setValue(employee);
	}

	@PostMapping(value = "/setAllValue")
	public String setAllValue(@RequestBody List<Employee> employees) throws LessSalaryException {
		return es.setAllValue(employees);
	}
	@GetMapping(value="/getAllValue")
	public List<Employee> getAllValue() {
		PropertyConfigurator.configure("employee.properties");
		log.info(es.getAllValue());
		return es.getAllValue();
	}

}
