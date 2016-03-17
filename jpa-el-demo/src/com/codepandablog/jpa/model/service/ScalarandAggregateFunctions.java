package com.codepandablog.jpa.model.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ScalarandAggregateFunctions {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpa-el-demo");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("Select UPPER(e.ename) from Employee e");
		List<String> eList = query.getResultList();
		for (String eName : eList) {
			System.out.println("Employee NAME :" + eName);
		}
		// Aggregate function
		Query query1 = entitymanager.createQuery("Select MAX(e.salary) from Employee e");
		Double result = (Double) query1.getSingleResult();
		System.out.println("Max Employee Salary :" + result);
		
		Query query3 = entitymanager.createQuery("Select e.ename,MAX(e.salary) from Employee e");
		List<Object[]> list3=query3.getResultList();
		System.out.println("Max Employee Salary :");
		for(Object[] obj:list3){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}
}
