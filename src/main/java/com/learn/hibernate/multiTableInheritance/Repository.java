package com.learn.hibernate.multiTableInheritance;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.SecondaryTableSecondPass;

import com.learn.hibernate.util.HibernateUtil;

public class Repository extends HibernateUtil{

	
	public void saveOrUpdate(ManageProduct product){
		Session session = getSession();
		session.saveOrUpdate(product);
		t.commit();
		session.close();
	}
	public void mergeUpdate(ManageProduct product){
		Session session = getSession();
		session.merge(product);
		t.commit();
		session.close();
	}
	public void removeBookPen(String author, String color){
		System.out.println("deleting book or pen");
		String str="";
		Session session = getSession();
		if(author != null)
			str = "delete Book where author='"+author+"'";
		if(color != null)
			str = "delete Pen where color='"+color+"'";
		session.createQuery(str).executeUpdate();
		t.commit();
		session.close();
		System.out.println("deleted book or pen");
	}
	
	public ManageProduct getManageProduct(){
		Session session = getSession();
		Query query = session.createQuery("FROM ManageProduct");
		List<ManageProduct> product = (List<ManageProduct>) query.list();
		session.close();
		return product.size() > 0?product.get(0):null;
		
	}
	public void clean(){
		factory.close();
	}
}
