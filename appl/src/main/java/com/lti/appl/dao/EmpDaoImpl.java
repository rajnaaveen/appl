package com.lti.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.beans.Employee;
import com.lti.appl.exceptions.CustomEmpException;

////@Repository("empDao")
@Repository
public class EmpDaoImpl implements EmpDao {

	@PersistenceContext
	private EntityManager em;

	public List<Employee> listAllEmployees() {
		// String sql = "Select e From Employee e where e.empName ='Jay'";
		String sql = "Select e From Employee e";
		Query qry = em.createQuery(sql);
		List<Employee> empList = qry.getResultList();

		// can be done using Query

		// String sql = "SELECT e FROM empRec e where e.empno=?"; //Query qry =
		em.createQuery(sql); // List<Employee> empList =
		qry.getResultList();
		return empList;

	}

	@Transactional
	public int addEmployee(Employee e) {
		System.out.println(" dao Layer");
		em.persist(e);
		return e.getEmpNo();
	}

	public Employee getEmpById(int empNo) {
		System.out.println("dao ");

		Employee e = em.find(Employee.class, empNo);

		return e;

	}
	
	@Transactional
	public double updateSalary(Employee e) throws CustomEmpException {
		
		Employee emp = em.find(Employee.class,e.getEmpNo());// db old record 

		if (emp != null) {
			emp.setEmpSal(e.getEmpSal());// new sal set
			em.merge(emp);

			return emp.getEmpSal();
		} else {
			throw new CustomEmpException("Emp does not exsit");
		}
	}

}
