package com.kiramario.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Demo1 {
	public static void main(String[] args){
		 Configuration conf = new Configuration().configure("hibernate.cfg.xml");
         StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
         SessionFactory sf = conf.buildSessionFactory(builder.build());
     
//		SessionFactory sf = conf.buildSessionFactory();
		Session session=sf.openSession();  
		session.beginTransaction();
		Customer customer = new Customer("KIRAMARIO","123456");
		session.save(customer);
		System.out.println("±£´æ³É¹¦");
		session.getTransaction().commit();
		session.close();
		sf.close();
	}	
}