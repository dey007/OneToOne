package org.arka.mvc.dao;

import java.util.List;

import org.arka.mvc.bean.Employee;



public interface EmployeeDao {
	
	public List<Employee> findAllByAge(int age);

	public int insert(Employee emp);

}
