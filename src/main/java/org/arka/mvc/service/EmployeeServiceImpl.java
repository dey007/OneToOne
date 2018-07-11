package org.arka.mvc.service;

import java.util.List;

import org.arka.mvc.bean.Employee;
import org.arka.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;
	
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> findAllByAge(int age) {
		return employeeDao.findAllByAge(age);
	}

	@Override
	public int insert(Employee emp) {
		//System.out.println(emp.getAge()+" "+emp.getEmpId()+" "+emp.getEmpName());
		return employeeDao.insert(emp);
		
	}

}
