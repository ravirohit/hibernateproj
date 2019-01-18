package com.learn.hibernate.entity.association;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	int addressId;
	String apart;
	String street;
	
	public Address(){
		
	}
	
	public Address(String apart, String street){
		this.apart = apart;
		this.street = street;
	}
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getApart() {
		return apart;
	}
	public void setApart(String apart) {
		this.apart = apart;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	
	
}
