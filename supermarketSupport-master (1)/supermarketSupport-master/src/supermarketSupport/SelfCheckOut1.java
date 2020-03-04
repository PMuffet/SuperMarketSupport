package supermarketSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelfCheckOut1 {
	private Stock stock;
	private ArrayList<SalesLineItem> shoppingCart = new ArrayList<>();;
	Scanner input = new Scanner(System.in);
	public SelfCheckOut1(Stock stock) {
		this.stock = stock;	
	}
	
	//return item and price; search by ID and by name
	public Product searchProduct(String name) { 
		 Product product = findProductID(name);
		System.out.println(product.getProductName() + "Price "+ product.getPrice()+ " Bulk buy discout price "+ product.getDiscountBulkBuyPrice()+ 
				" Promotion discount Price "+ product.getDiscountPromotionPrice());
		return product;
	}
	//method for adding item to shopping cart
	public void addItemToPurchase(Product product,int amount) {
		SalesLineItem productsale = new SalesLineItem(product,amount);
		shoppingCart.add(productsale);
		System.out.println(product.getProductName() + " add to shopping cart");
		displayShoppingCart();
	}
	//method for removing item from shopping cart
	public void removeItemToPurchase(String name) {
		Product product = findProductID(name);
		for(int i=0;i<shoppingCart.size();i++) {
			if(shoppingCart.get(i).getProduct().equals(product)) {
				SalesLineItem productsale = shoppingCart.get(i);
				shoppingCart.remove(productsale);
				System.out.println(productsale.getProductName()+" remove for shopping cart");
			}
		}
		displayShoppingCart();
	}
	
	public ArrayList<SalesLineItem> getShoppingCart() {
		return shoppingCart;
	}
	//method for finding product by ID
	private Product findProductID(String ID) {
		for (int i = 0; i < stock.getProducts().size(); i++) {
			if (stock.getProducts().get(i) != null) {
				if (stock.getProducts().get(i).getProductName().equals(ID)||stock.getProducts().get(i).getProductID().equals(ID)) {
					return stock.getProducts().get(i);
				}
			}
		}
		return null;
	}
	//method to display shopping cart to user
	public void displayShoppingCart() {
		double sum = 0;
		if(shoppingCart.size()>0) {
		for(int i=0; i<shoppingCart.size();i++) {
			System.out.println(shoppingCart.get(i).getProductName() + " amount "+shoppingCart.get(i).getAmount()+ " Total price "+shoppingCart.get(i).calculateSale());
			sum+=shoppingCart.get(i).calculateSale();
			}
		System.out.println("Total :" + sum);
		}else {
			System.out.println("No item in shopping cart");
		}
	}
	
	public void cancelPurchase() {	//if SalesEmployee
		shoppingCart.clear();
	}

}
