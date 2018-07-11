package org.arka.mvc.service;

import java.util.List;

import org.arka.mvc.bean.Employee;


public interface EmployeeService {
	public List<Employee> findAllByAge(int age);

	public int insert(Employee emp);

}
