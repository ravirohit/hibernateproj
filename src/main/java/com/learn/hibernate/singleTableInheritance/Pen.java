package com.learn.hibernate.singleTableInheritance;

import javax.persistence.Entity;

@Entity
public class Pen extends MyProduct {
    private String color;
    
    Pen(){
    	
    }
    Pen(String color){
    	this.color = color;
    }
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
    
}