package supermarketSupport;

import java.util.ArrayList;

public class Stock {

	public Stock() {	
	}
	
	public Stock(ArrayList<Product> products) {
		this();
		this.products = products;
	}
	
	public Product getProduct(String pName) {
		for(int i=0;i<products.size();i++) {
			Product product = products.get(i);
			{
			if(product.getProductName().equals(pName)|| product.getProductID().equals(pName))
				return product;
			}
		}
		return null;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void deletePrduct(Product product) {
		products.remove(product);
		System.out.println(product.getProductName()+ " remove from Stock ");
	}
	
	public void topUpProduct(Product product,int amount) {
		if(products.contains(product)) { // check if product in stock
			amount += product.getQuantity();
			product.setQuantity(amount);
			System.out.println(product.getProductName()+" has been top up");
		}
	}

	protected ArrayList<Product> products = new ArrayList<Product>();

	public String displayStock() {
		String productInfo = "";
		if (products == null) { 
			return "empty";
		}
		else {
			for (Product product : products) {
				if (product != null) {
					productInfo += "\n----------------------------------\n" + product.printDetails() 
					+ "\n----------------------------------\n";
				}
			}
		}
			return productInfo;
		}				
	public ArrayList<Product> getProducts()// Wachira add getProduct() so can get list of product
	{
		return products;
	}
}
