package supermarketSupport;

import java.util.ArrayList;
import java.util.Scanner;

public class SelfCheckOut {
	private Stock stock;
	private ArrayList<SalesLineItem> shoppingCart = new ArrayList<>();;
	private ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
	Scanner input = new Scanner(System.in);
	private String cardNumber;
	private String empId;
	double totalamount;
	public SelfCheckOut(Stock stock) {
		this.stock = stock;
		
	}
	
	
	public void displayCheckOutMenu() {
		System.out.println("**** SUPERMARKET SYSTEM MENU ****");
		System.out.println("Look up item:              1");
		System.out.println("Purchase item:             2");
		System.out.println("Staff menu:                3");
	}
	
	public void displayStaffMenu() {
		System.out.println("     ** STAFF MENU ** ");
		System.out.println("Remove item:              4");
		System.out.println("Cancel transaction:       5");
		System.out.println("Sell debit card:          6");
		System.out.println("Top-up debit card:        7");
		System.out.println("Exit:                     8");
	}
	
	//perform tasks based on menu selection
//	public void readInputAndPerformTasks() {
//		System.out.println("Customers enter 0");
//		System.out.println("Staff enter 9");
//		int userAnswer = 0;
//		userAnswer = input.nextInt();
//		while (userAnswer != 0 || userAnswer != 9) {
//		   if (userAnswer==0) {
//			   System.out.println("Please enter your customer debit card number: ");
//			   cardNumber = input.next();
//			   searchAndReturn(cardNumber);
//		   }
//		   else if (userAnswer==9) {
//			   System.out.println("Please enter your employee ID: ");
//			   empId = input.next();
//		   }
//		}
//		
//		displayCheckOutMenu();
//		
//			while (userAnswer != 8) {
//				System.out.println("Enter your choice: 			");
//				int userChoice = input.nextInt();
//				if (userChoice == 1) {
//				}
//				if (userChoice == 2) {
//					//purchaseItem();
//				}
//				if (userChoice == 3) {
//					displayStaffMenu();
//					while (userChoice >= 4 && userChoice <= 8) {
//						if (userChoice == 4) {
//							removeItemFromPurchase();
//						}
//						if (userChoice == 5) {
//							cancelPurchase();
//						}
//						if (userChoice == 6) {
//							sellCard();
//						}
////						if (userChoice == 7) {
////							topUpCard(cardNumber); //change input
////						}
//					}
//				
//				displayCheckOutMenu();
//				}
//		}
//	}
		
	public CreditCard sellCard() {
		System.out.println("Enter debit card number: ");
		cardNumber = input.next();
		System.out.println("Enter expiry date (ddyyyy format): ");
		String expiryDate = input.next();
		System.out.println("Enter customer's name: ");
		String nameOnCard = input.next();
		System.out.println("Enter initial debit card balance: ");
		double cardBalance = input.nextDouble();
		CreditCard card = new CreditCard(cardNumber, expiryDate, nameOnCard, cardBalance);
		System.out.println("Thank you for your purchase!");
		cards.add(card); //add to ArrayList
		Customer customer = new Customer(nameOnCard); //create customer
		return card;
	}
	
	//checks customers Hashmap for existence of customers with the specific cc number
	public void searchAndReturn(String cardNumber) {
	
		
	}
			
	public void topUpCard(CreditCard card) {
		double ccBalance = card.getCardBalance();
		System.out.println("Enter top-up amount:");
		double topUp = input.nextDouble();
		ccBalance += topUp;
		System.out.println("New balance: $" + ccBalance);
	}
	
	

	
	
	public Product searchProduct(String name) { //return item and price; search by ID and by name
		 Product product = findProductID(name);
		System.out.println(product.getProductName() + "  Price $"+ String.format("%.2f",product.getPrice())+ " Bulk buy discout price $"+ String.format("%.2f",product.getDiscountBulkBuyPrice())+ "  Bulk buy ("+product.getItemNumDiscount()+ ") piece Min Order) "  + 
				"  Promotion discount Price $ "+ String.format("%.2f",product.getDiscountPromotionPrice()));
		System.out.println();
		return product;
	}
	public void addItemFromPurchase(Product product,int amount) {
		SalesLineItem productsale = new SalesLineItem(product,amount);
		shoppingCart.add(productsale);
		System.out.println(product.getProductName() + " add to shopping cart");
		displayShoppingCart();
	}
	
	public void removeItemFromPurchase(String name) {
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
	
	public void displayShoppingCart() {
		double sum = 0;
		if(shoppingCart.size()>0) {
		for(int i=0; i<shoppingCart.size();i++) {
			System.out.println(shoppingCart.get(i).getProductName() + " amount "+shoppingCart.get(i).getAmount()+ " Total price "+String.format("%.2f",shoppingCart.get(i).calculateSale()));
			sum+=shoppingCart.get(i).calculateSale();
			totalamount=sum;
			}
		System.out.println("Total :" + sum);
		}else {
			System.out.println("No item in shopping cart");
		}
	}
	
	public double getTotalamount() {
		return totalamount;
	}

	public void cancelPurchase() {	//if SalesEmployee
		shoppingCart.clear();
		System.out.println("transaction has been cancel");
	}

}
	