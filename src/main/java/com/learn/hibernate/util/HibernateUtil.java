package com.learn.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	  StandardServiceRegistry ssr = null;
	  Metadata meta = null;
	 public SessionFactory factory = null;
	  Session session = null;
	 public Transaction t = null;
	
	public HibernateUtil(){
		ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();		
    	meta = new MetadataSources(ssr).getMetadataBuilder().build();
    	factory = meta.getSessionFactoryBuilder().build();
	}

	 public Session getSession(){
		 session = factory.openSession();
		 t = session.beginTransaction();   
		 return session;  
	 }
}
