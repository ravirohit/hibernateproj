package com.learn.hibernate.mainapp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.learn.hibernate.entity.inheritance.MessagingConfigEntity;
import com.learn.hibernate.entity.inheritance.MessagingEnablerCfg;
import com.learn.hibernate.entity.inheritance.MessagingSessionCfg;
import com.learn.hibernate.util.HibernateUtil;

public class Respository extends HibernateUtil{
	Respository(){
		super();
	}
	
	public void saveUpdateMessagingSession(MessagingEnablerCfg e){
		System.out.println("saving");
		Session session = getSession();
 	    session.saveOrUpdate(e);;  
 	    t.commit();
 	    System.out.println("saved");
 	    session.close();
		
	} 
	public void updateMessagingSession(MessagingEnablerCfg e){
		System.out.println("updating");
		Session session = getSession();
 	    session.merge(e);;  
 	    t.commit();
 	    System.out.println("updated");
 	    session.close();
		
	} 
	
	public List<MessagingEnablerCfg> getMessagingEnablerCfg(){
		Session session = getSession();
		System.out.println("getting MessagingConfigEntity");
		String queryStr = "From MessagingEnablerCfg";
		Query query = session.createQuery(queryStr);
		List<MessagingEnablerCfg> list = query.list();
		System.out.println("got");
		session.close();
		return list;
	}
	
	public MessagingConfigEntity getMessagingSession(String name){
		Session session = getSession();
		System.out.println("getting");
		String queryStr = "From MessagingSessionCfg session where session.sessionName = '"+name+"'";
		Query query = session.createQuery(queryStr);
		List<MessagingConfigEntity> list = query.list();
		System.out.println("query list:"+list.size());
		System.out.println("got");
		session.close();
		return list.size() > 0 ? list.get(0): null;
	}
	
	public void deleteMessagingSession(MessagingConfigEntity messagingSessionCfg){
		Session session = getSession();
		System.out.println("deleting");
		session.delete(messagingSessionCfg);
		System.out.println("deleted");
		t.commit();
		session.close();
		
	}

	public void clean(){
		///t.commit();
		factory.close();  
	}
}
