package com.tns.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritanceTest {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		//create one employee
		Employee employee = new Employee();
		employee.setEmp_name("Touhid");
		employee.setEmp_salary(5000);
		em.persist(employee);
		
		//create one manager
		Manager manager = new Manager();
		manager.setEmp_name("Trisha");
		manager.setEmp_salary(8000);
		manager.setDepartmentName("Sales");
		em.persist(manager);
		
		Manager manager1 = new Manager();
		manager1.setEmp_name("Govind");
		manager1.setEmp_salary(8000);
		manager1.setDepartmentName("Development");
		em.persist(manager1);
		
		
		em.getTransaction().commit();
		
		System.out.println("Added one employee and manager to database.");
		//em.close();
		//factory.close();
	}
}