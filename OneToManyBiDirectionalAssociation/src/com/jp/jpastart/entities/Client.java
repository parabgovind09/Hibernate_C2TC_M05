package com.jp.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
//		Department department1 = new Department();
////		department.setId(10);
//		department1.setName("Science");
//		
//		Department department2 = new Department();
////		department.setId(11);
//		department2.setName("Maths");
//
//		Employee employee1 = new Employee();
////		employee1.setEid(101);
//		employee1.setEname("Govind");
//		employee1.setEsalary(10000);
//		
//		Employee employee2 = new Employee();
////		employee2.setEid(102);
//		employee2.setEname("Minal");
//		employee2.setEsalary(20000);
//		
//		Employee employee3 = new Employee();
////		employee3.setEid(103);
//		employee3.setEname("Sahil");
//		employee3.setEsalary(15000);
		
//		department1.addEmployee(employee1);
//		department2.addEmployee(employee2);
//		
//		department1.addEmployee(employee3);
		
		
//		em.persist(department1);
//		em.persist(department2);
		
//		System.out.println("Record added in the database");
		em.getTransaction().commit();

	}

}
