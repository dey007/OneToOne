package org.arka.mvc.controller;

import java.util.List;

import org.arka.mvc.bean.Employee;
import org.arka.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@RequestMapping(value ="/findAge/{age}", method=RequestMethod.GET)
	@ResponseBody
	public  List<Employee> findAllByAge(@PathVariable("age") int age){
		
		System.out.println(age);
		return employeeService.findAllByAge(age);
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	public int insertEmp(@RequestBody Employee emp){
		//System.out.println(emp.getAge()+" "+emp.getEmpId()+" "+emp.getEmpName());
		return employeeService.insert(emp);
		
		
	}

}
