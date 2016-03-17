package com.codepandablog.jpa;

import com.codepandablog.jpa.model.Employee;
import com.codepandablog.jpa.model.service.EmployeeService;

public class EmployeeJpaDemo {

	public static void main(String[] args) {
		
		Employee employee=new Employee(101,"Hem Chandra",30000,"SA");
		//new EmployeeService().createEmployee(employee);
		//new EmployeeService().updateEmployee(101);
		new EmployeeService().deleteEmployee(101);
	}

}
