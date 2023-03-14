package com.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritanceTest2 {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
//		//create one employee
//		Employee2 employee = new Employee2();
//		employee.setEmp_name("Vishnu");
//		employee.setEmp_salary(5000);
//		em.persist(employee);
//		
//		//create one manager
//		Manager2 manager = new Manager2();
//		manager.setEmp_name("Govind");
//		manager.setEmp_salary(9000);
//		manager.setDepartment_name("Developer");
//		em.persist(manager);
		
		//create one employee
				Employee2 employee = new Employee2();
				employee.setEmp_name("Madhusudan");
				employee.setEmp_salary(5000);
				em.persist(employee);
				
				//create one manager
				Manager2 manager = new Manager2();
				manager.setEmp_name("Janardana");
				manager.setEmp_salary(9000);
				manager.setDepartment_name("Analyst");
				em.persist(manager);
		
		em.getTransaction().commit();
		
		System.out.println("Added one employee and manager to database.");
		//em.close();
		//factory.close();
	}
}
