package com.learn.hibernate.entity.association;

import org.hibernate.Session;

import com.learn.hibernate.util.HibernateUtil;

public class Repository extends HibernateUtil{
	
	
	Repository(){
		super();
	}

	public void saveOrUpdate(Employee emp){
		Session session = getSession();
		try{
			session.saveOrUpdate(emp);
		}
		catch(Exception e){
			System.out.println("Exception while save or udpate emp:"+e);
		}
		
		
	}

}
