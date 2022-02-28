package com.lti.appl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.beans.Employee;
import com.lti.appl.exceptions.CustomEmpException;
import com.lti.appl.services.EmpServiceImpl;
import com.lti.appl.services.EmployeeJpaRepService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmpServiceImpl empService;
	
	@Autowired
	private EmployeeJpaRepService empService1;
		
	
	//http://localhost:8080/emp/listall
	
	@GetMapping("/listall")
	public List<Employee> listAllEmployees()
	{
		System.out.println(" inside controller ");
		return empService.listAllEmployees();		
	}

	
	 @PostMapping("/addemp") 
	 public int addEmp(@RequestBody Employee e) { 
	 return empService.addEmployee(e);
	 }
	 
	 @PutMapping("/updateemp") 
	 public double updateSalary(@RequestBody Employee e)
	     throws CustomEmpException { 
		 return empService.updateSalary(e);
	 }
	 
	
	
}
