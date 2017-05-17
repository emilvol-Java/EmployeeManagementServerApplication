package com.virtualpairprogrammers.employeemanagement.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.virtualpairprogrammers.employeemanagement.domain.Employee;

@Stateless
@Alternative
@TestingDao
public class EmployeeDataAccessTestingVersion implements EmployeeDataAccess {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void insert(Employee newEmployee) {
		
	}
	
	@Override
	public void delete(String surname){
		List<Employee> employees = findBySurname(surname);
		
		for (Employee employee : employees){
				em.remove(employee);
		}
		
	}
	
	
	@Override
	public List<Employee> findAll() {
		Employee e1 = new Employee("James","Green","Writer",1700);
		Employee e2 = new Employee("Sharon","White","Editor",2100);
		Employee e3 = new Employee("Darren","Blue","Manager",31250);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		return employees;
	}

	@Override
	public List<Employee> findBySurname(String surname) {
		return null;
	}

}
