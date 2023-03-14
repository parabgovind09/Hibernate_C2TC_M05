package com.tns.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Inheritance_Two {
	public static void main(String args[]) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
//		//create one employee
//		Employee_Two employee = new Employee_Two();
//		employee.setEmp_name("Govind");
//		employee.setEmp_salary(8000);
//		em.persist(employee);
//		
//		//create one manager
//		Manager_Two manager = new Manager_Two();
//		manager.setEmp_name("Vishnu");
//		manager.setEmp_salary(10000);
//		manager.setDepartment_name("Development");
//		em.persist(manager);

		//create one employee
				Employee_Two employee = new Employee_Two();
				employee.setEmp_name("Narayan");
				employee.setEmp_salary(8000);
				em.persist(employee);
				
				//create one manager
				Manager_Two manager = new Manager_Two();
				manager.setEmp_name("Krishna");
				manager.setEmp_salary(10000);
				manager.setDepartment_name("Development");
				em.persist(manager);
		
		em.getTransaction().commit();
		System.out.println("Added one employee and manager to database.");
	}
}
