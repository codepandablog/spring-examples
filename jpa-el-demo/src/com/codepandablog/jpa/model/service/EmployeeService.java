package com.codepandablog.jpa.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.codepandablog.jpa.model.Employee;

public class EmployeeService {
	
	public void createEmployee(Employee employee){
		EntityManagerFactory factory=getEntityManagerFactory("jpa-el-demo");
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
	
	public void updateEmployee(int employeeId){
		EntityManagerFactory factory=getEntityManagerFactory("jpa-el-demo");
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee=entityManager.find(Employee.class,employeeId);
		System.out.println("Employee Before Update:");
		System.out.println(employee);
		employee.setSalary(120000);
		System.out.println("Employee After Update:");
		System.out.println(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

	public void deleteEmployee(int employeeId){
		EntityManagerFactory factory=getEntityManagerFactory("jpa-el-demo");
		EntityManager entityManager=factory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee=entityManager.find(Employee.class,employeeId);
		System.out.println("Deleting employee with employeeID::"+employeeId);
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
	private EntityManagerFactory getEntityManagerFactory(String entityManagerFactory){
		return Persistence.createEntityManagerFactory(entityManagerFactory);
	}
}
