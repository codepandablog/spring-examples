package com.codepandablog.jpa.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.codepandablog.jpa.model.Department;
import com.codepandablog.jpa.model.DepartmentEmployee;

public class ManyToOne {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-el-demo");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Create Department Entity
		Department department = new Department();
		department.setName("Development");

		// Store Department
		entitymanager.persist(department);

		// Create Employee1 Entity
		DepartmentEmployee employee1 = new DepartmentEmployee();
		employee1.setEname("Satish");
		employee1.setSalary(45000.0);
		employee1.setDeg("Technical Writer");
		employee1.setDepartment(department);

		// Create Employee2 Entity
		DepartmentEmployee employee2 = new DepartmentEmployee();
		employee2.setEname("Krishna");
		employee2.setSalary(45000.0);
		employee2.setDeg("Technical Writer");
		employee2.setDepartment(department);

		// Create Employee3 Entity
		DepartmentEmployee employee3 = new DepartmentEmployee();
		employee3.setEname("Masthanvali");
		employee3.setSalary(50000.0);
		employee3.setDeg("Technical Writer");
		employee3.setDepartment(department);

		// Store Employees
		entitymanager.persist(employee1);
		entitymanager.persist(employee2);
		entitymanager.persist(employee3);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

}
