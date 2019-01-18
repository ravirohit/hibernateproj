package com.learn.hibernate.entity.association;

public class MainApp {

	public static void main(String[] args) {
       System.out.println("------- association ---------");
       
       Repository repo = new Repository();
       Employee emp1= new Employee("rohit@gmail.com","abc");
       Address add1 = new Address("aprt1","no 2");
       Address add2 = new Address("aprt2","no 2");
       
       emp1.getAddress().add(add1);
       emp1.getAddress().add(add2);
       
       repo.saveOrUpdate(emp1);
       

	}

}
