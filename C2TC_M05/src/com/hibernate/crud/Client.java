package com.hibernate.crud;

import org.hibernate.Session;

public class Client {

	public static void main(String[] args) 
	{

		Session session=HibernateDbConnect.getSessionFactory().openSession();

        /*//CRUD
        //inserting
		Users user=new Users("Touhid","34567","Touhid","Sayyed");
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();*/
		
		/*
		//retriving
		Users user1=new Users(); 
		session.beginTransaction();
		user1=session.get(Users.class, 2); 
		System.out.println(user1);
		session.getTransaction().commit();
		*/
		
		/*
		updating
		Users user2=new Users(); 
		session.beginTransaction();
		user2=session.get(Users.class, 3); 
		user2.setLastname("Rajput");
		System.out.println(user2); 
		session.getTransaction().commit();
		*/
		
		/*
		//deleting
		Users user3=new Users(); 
		session.beginTransaction();
		user3=session.get(Users.class, 4); 
		session.delete(user3);
		session.getTransaction().commit();
		*/
	}

}
