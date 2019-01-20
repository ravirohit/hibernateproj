package com.learn.hibernate.singleTableInheritance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class ManageProduct extends MyProduct {
	
	String myproduct;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Book> book = new ArrayList<>();
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Pen> pen = new ArrayList<>();
	
	public ManageProduct(){
		
	}
	public ManageProduct(String myproduct){
		this.myproduct = myproduct;
	}
	
	/*public ManageProduct(Book book, Pen pen){
		this.book = book;
		this.pen = pen;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Pen getPen() {
		return pen;
	}
	public void setPen(Pen pen) {
		this.pen = pen;
	}*/

	public String getMyproduct() {
		return myproduct;
	}
	public void setMyproduct(String myproduct) {
		this.myproduct = myproduct;
	}
	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public List<Pen> getPen() {
		return pen;
	}

	public void setPen(List<Pen> pen) {
		this.pen = pen;
	}
	public void addBook(Book book){
		this.book.add(book);
	}
	public void addPen(Pen pen){
		this.pen.add(pen);
	}
	public void removeBook(String author){
		this.book.removeIf(b -> b.getAuthor().equals(author));
	}
	public void removePen(String color){
		this.pen.removeIf(b -> b.getColor().equals(color));
	}
	

}
