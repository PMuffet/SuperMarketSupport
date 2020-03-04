package supermarketSupport;

import java.util.ArrayList;

public class DummyProducts {
	
	private ArrayList<Product> products;
	
	public DummyProducts(){
		Supplier	DairyPlus = new Supplier ("001", "DairyPlus", "15 Nepean Highway Brighton","95921234");
		Supplier MeatPro = new Supplier ("002", "MeatPro", "20 Schofield St Moorabbin","95981124");
		Supplier GoodLongLife = new Supplier ("003", "GoodLongLife", "12 Long St Melbourne","95985544");
		Supplier QuidProNo = new Supplier ("004", "QuidProNo", "15 Short Rd Melbourne","99551452");	 
		products = new ArrayList<>();
		Product Apples = new Product ("F001", "Apples", 5, 100, 20,3,DairyPlus);
		Product Bananas = new Product ("F002", "Bananas", 6, 150, 20,4.5,GoodLongLife);
		Product	Sausage = new Product ("M001", "Sausage", 10, 50, 5,8,MeatPro);
		Product	Steak = new Product ("M002", "Steak", 8, 60, 5,6.5,MeatPro);
		Product	Pork = new Product ("M003", "Pork", 7, 70, 5,6,MeatPro);
		Product	Strawberries = new Product ("F003", "Strawberries", 4, 200, 20,3,GoodLongLife);
		Product	CannedBeans = new Product ("L001", "Canned Beans", 2, 100, 30,1,GoodLongLife);
		Product	CannedPickles = new Product ("L002", "Canned Pickles", 2, 120, 30,1,DairyPlus);
		Product	Eggs = new Product ("M004", "Eggs", 7, 40, 20,5,DairyPlus);
		Product	DogFood = new Product ("P001", "Dog Food", 5, 10, 5,4,QuidProNo);
		Product	CatFood = new Product ("P002", "Cat Food", 4, 15, 5,2.5,QuidProNo);
		Product	Ham = new Product ("M005", "Ham", 5, 30, 25,4,MeatPro);
		products.add(Eggs);
		products.add(CannedPickles);
		products.add(CannedBeans);
		products.add(Strawberries);
		products.add(Apples);
		products.add(Steak);
		products.add(Sausage);
		products.add(Pork);
		products.add(CatFood);
		products.add(DogFood);
		products.add(Ham);
		products.add(Bananas);
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
}
