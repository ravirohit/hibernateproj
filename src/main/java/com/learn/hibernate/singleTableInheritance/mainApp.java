package com.learn.hibernate.singleTableInheritance;

public class mainApp {

	static Repository repo = new Repository();
	public static void main(String[] args) {
		
		// saving data
		//saveData(null,null,null);
		
		// updating or merging data
		ManageProduct product = getProcessedData("authorName1",null);
		saveData(product,"authorName1",null );
		
		
		repo.clean();
        
	}
	public static void saveData(ManageProduct product,String author, String color){
		if(product == null) {
			System.out.println("saving data");
			Book book1 = new Book("authorName1");
			Book book2 = new Book("authorName2");
			Pen pen1 = new Pen("ColorName1");
			product = new ManageProduct("myproduct1");
			product.addBook(book1);
			product.addBook(book2);		
			product.addPen(pen1);
			repo.saveOrUpdate(product); // saving data actually
			System.out.println("saved");
		}
		else{
			System.out.println("updating data");
			repo.mergeUpdate(product);
		//	repo.removeBookPen(author, color);
			System.out.println("updated");
		}
        
        
	}
	public static ManageProduct getProcessedData(String author,String color){
		System.out.println("getting Manageproduct from db");
		ManageProduct manageProduct = repo.getManageProduct();
		manageProduct.removeBook(author);
		return manageProduct;
	}
	

}



