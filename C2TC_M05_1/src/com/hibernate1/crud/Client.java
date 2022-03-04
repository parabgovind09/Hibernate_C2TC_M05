package com.hibernate1.crud;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

public class Client {

	public static void main(String[] args) {
		Session session=HibernateDbConnect.getSessionFactory().openSession();
		try {
			
			//deleting
			/*String str = "delete users where firstname = 'Suraj' ";
			session.beginTransaction();
			
			Query query = session.createQuery(str);
			query.executeUpdate();
			session.getTransaction().commit();*/
			
			/*
			//retriving
			String str = "from users";
			session.beginTransaction();
			Query query = session.createQuery(str);
			List<Users> l1 =  query.getResultList();
			for(Users u : l1) {
				System.out.println(u);
			}
			
			session.getTransaction().commit();
			*/
			
			/*
			//updating
			String str = "update users set password = '1212' where password='12345'";
			session.beginTransaction();
			Query query = session.createQuery(str);
			query.executeUpdate();
			session.getTransaction().commit();
			*/
			
			/*
			//insertinng
			session.beginTransaction();
			Users user1 = new Users("Suraj","12345","Suraj","Prajapati");
			session.save(user1);
			session.getTransaction().commit();
			*/
			
		}finally {
			session.close();
		}
	}

}
