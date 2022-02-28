package com.lti.appl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.appl.beans.Employee;
import com.lti.appl.dao.EmpJpaDaoRepository;

@Service
public class EmployeeJpaRepService implements EmpService {
	
	//EmpDao empDao  EmpDapImpl - manual @ em.persist em.remvoe 
	
	@Autowired
	private EmpJpaDaoRepository daoJpaRep;

	@Override
	public List<Employee> listAllEmployees() {
		System.out.println("inside Services");
		List<Employee> empList=daoJpaRep.findAll();
		return empList;
	}	

}

/* Why Optional ?
very Java Programmer is familiar with NullPointerException. 
It can crash your code. And it is very hard to avoid it without using too many null checks.
Java 8 has introduced a new class Optional in java.util package.
 It can help in writing a neat code without using too many null checks. 
 By using Optional, we can specify alternate values to return or alternate code to run. 
 This makes the code more readable because the facts which were hidden are now visible to the developer.
*/