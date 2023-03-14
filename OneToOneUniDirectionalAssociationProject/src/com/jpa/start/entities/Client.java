package com.jpa.start.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Student student = new Student();
		student = em.find(Student.class, 74); 
//		student.setStudent_name("Minal");
		
		Address address = new Address();
		address = em.find(Address.class, 75); 
//		address.setStreet("S.V. Road");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setZipcode("400064");
//		
//		
//		//injecting address into student
//		student.setAddress(address);
//		
//		//persist only student no need to persist address explicitly
//		em.persist(student);
		System.out.println(student.getStudent_name());
//		System.out.println(address.getCity());
		System.out.println(student.getAddress().getCity());
		em.getTransaction().commit();
		
//		System.out.println("Added one student with address in database");

	}

}
