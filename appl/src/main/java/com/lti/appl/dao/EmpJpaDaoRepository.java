package com.lti.appl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.appl.beans.Employee;


//No More DAO Implementations  !!!!!

// SpringJataJpa 

public interface EmpJpaDaoRepository  extends JpaRepository<Employee, Integer>{


	

}
