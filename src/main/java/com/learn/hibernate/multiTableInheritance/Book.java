package com.learn.hibernate.multiTableInheritance;

import javax.persistence.Entity;

@Entity
public class Book extends MyProduct {
    private String author;
    
    Book(){
    	
    }
    Book(String author){
    	this.author = author;
    }
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    
}
	


