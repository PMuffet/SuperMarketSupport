package supermarketSupport;

import java.util.ArrayList;
import java.util.Scanner;

public class SupermarketSystem {
	private ArrayList<Supplier> supplierlists=new ArrayList<>();
	private ArrayList<SalesLineItem> productSaleList=new ArrayList<>();
	private Stock stock = new Stock(new DummyProducts().getProducts()); ;	
	private Order orderList = new Order();
	private ArrayList<Employee> employees = new ArrayList<>();
	static Scanner in = new Scanner(System.in);	
	private String position;
	boolean quit;
	String n ;
	Product p;
	SelfCheckOut selfCheck = new SelfCheckOut(stock);
	private CreditCard card = new CreditCard();
	private Customer  customer = new Customer("C001","Hanah","3 Lawes Street","Hawthorn","3977",card,100);
	private Customer cus;
	private ArrayList<Customer> customerList = new ArrayList<>();
	
	//supermarket system constructor
	public SupermarketSystem() {
		Supplier DairyPlus = new Supplier ("001", "DairyPlus", "15 Nepean Highway Brighton","95921234");
		Supplier MeatPro = new Supplier ("002", "MeatPro", "20 Schofield St Moorabbin","95981124");
		Supplier GoodLongLife = new Supplier ("003", "GoodLongLife", "12 Long St Melbourne","95985544");
		Supplier QuidProNo = new Supplier ("004", "QuidProNo", "15 Short Rd Melbourne","99551452");	 
		Product product = new Product("100","Coke",2.5,10,10,0.5,DairyPlus);
		Product product1 =new Product("101","Milk",2,5,10,1,DairyPlus);
		Product product2 =new Product("102","cheese",7,5,10,5,QuidProNo);
		addSupplier(DairyPlus);
		addSupplier(MeatPro);
		addSupplier(GoodLongLife);
		addSupplier(QuidProNo);
		stock.addProduct(product);
		stock.addProduct(product1);
		stock.addProduct(product2);
		Employee manager = new Employee("Wachira",40,"M001","14 Lawes Street","041234567","M","manager","1234");
		Employee saleStaff = new Employee("Tim",26,"S001","36 Oak Street","041134567","M","salestaff","1111");
		Employee warehouseStaff = new Employee("John",21,"w001","4 broadway Street","04123000","M","warehouseStaff","2222");
		employees.add(manager);
		employees.add(saleStaff);
		employees.add(warehouseStaff);
		customerList.add(customer);
	}
	
	//activate system menu
	public void run()
		{
			systemMenu();
		}
		
		//takes staff login and validates details
		public boolean staffLogin() {
			System.out.println("Please enter your ID ");
			String id = in.next();
			System.out.println("Please enter your password ");
			String pass =in.next();
			for(Employee e:employees) {
				if(e.getEmpId().equals(id) && e.getPassword().equals(pass)) {
					position = e.getPositon();
					return true;
				}
			}
			return false;
			
		}
		public  void addSupplier(Supplier supplier) {// add supplier to the supplier lists
			supplierlists.add(supplier);
		}
		
		public void removeSupplier(Supplier supplier) {//remove supplier from the supplier lists
		 supplierlists.remove(supplier);
		}
		
		public void changePrice(Product product ,double price) {// change the product price
			product.setPrice(price);
		}
		
		public  void checkStock() { // check stock level of all product and automatically add to order list
			ArrayList<Product> productList = stock.getProducts();
			for (Product p : productList) {
				if(p.getQuantity() < p.getReplenishLevel()) {// check if stock level is under replenish 
				System.out.println("Product Name: "+ p.getProductName()+ " is under replenish Level need to be order");
				orderList.addProductToOrder(p,p.getReplenishLevel());
				}
			}
			orderList.showOrderList();
		}
		
		public void addOrder(Product product,int amount) { // add product to the list
			orderList.addProductToOrder(product,amount);
		}
		
		//set discount rate
		public void setDisPrice(Product product, double discountPer) {
			product.setDiscountPrice(product.getPrice()*(1-(discountPer/100)));
			
		}
		public Stock getStock() {
			return stock;
		}
		
		//display a list of sold products
		public void showProductSaleList() {
			for(SalesLineItem p: productSaleList) {
				System.out.println(p.getProductName()+ " sold "+p.getAmount()+" $"+p.getTotal()+" total amount sell "+ p.getTotalamount()+" stock level after sell "+ p.getProduct().getQuantity());
			}
		}
		
		//display items currently in stock
		public void showItemsInStock() {
			if (stock.getProducts().isEmpty()) {
				System.out.println("the stock is empty");
			}else {
			for (Product p:stock.getProducts()) {
				System.out.println(p.printDetails());
				System.out.println();
				}
			}
		}
		
		public void createSupplyReport() {
			System.out.println("Create supplier report");
		}
		
		//generate report displaying items producing the highest revenue
		public void createMostRevenueReport() {	
			for (int i =0;i<stock.getProducts().size();i++) {	
				System.out.println(stock.getProducts().get(i).getProductName()+" total sale is "+ stock.getProducts().get(i).getTotalSale());
			}
		}
		
		//display shopping menu
		public void shoppingMenu() {
			System.out.println("1. Add to item to shopping cart");	
			System.out.println("2. Back to previous Menu");
		}
		
		//display root menu
		public  void menu() {		
			System.out.println("***Welcome to Game of code super market***\nPlease choose an option:\n\n");	
			System.out.println("1. Customer: Checkout & Enquiries");
			System.out.println("2. Staff and Manger Only services");
		}	
	
		//display customer menu, take selection input and perform actions
		public  void customerMenu() {
			System.out.println("***Customer: Checkout & Enquiries***");			
			//LOGIN		
			System.out.println("Please choose an option:\n");
			System.out.println("1. Show shopping cart");
			System.out.println("2. Look up item by ID or Name");
			System.out.println("3. Remove item ");
			System.out.println("4. Check out");
			System.out.println("5. Cancel transaction");
			System.out.println("6. Exit");
			
			int choice = in.nextInt();
			switch(choice) {
			case 1:	selfCheck.displayShoppingCart();
					customerMenu();
					systemMenu();
				break;
			case 2: 
					System.out.println("Enter the product name or product ID :");
					String name = in.next();
					Product product = selfCheck.searchProduct(name);
					//System.out.println(product.printDetails());
					shoppingMenu();
					choice = in.nextInt();
					switch(choice) {
						case 1:
							System.out.println("Enter amount :");
							int amount = in.nextInt();
							selfCheck.addItemFromPurchase(product, amount);
							selfCheck.getShoppingCart();
							customerMenu();
							systemMenu();
							break;
						case 2:
							customerMenu();
							systemMenu();
							break;			
							}
					break;
				
			case 3:do {
						quit=staffLogin();
						}while(!quit);
							if(position.equals("salestaff")) {
							System.out.println("Enter the product name or product ID :");
							String productname = in.next();
							selfCheck.removeItemFromPurchase(productname);
							selfCheck.getShoppingCart();
						}
					customerMenu();
					systemMenu();	
				break;
				
			case 4: System.out.println("Your balance is $"+String.format("%.2f",cus.getBalance())+"  Total amount  $"+String.format("%.2f",selfCheck.getTotalamount()) + "You Loyalty Points is :"+cus.getLoyaltyPoints()+"\n"+
										"You can get $"+(5*(cus.getLoyaltyPoints()/20)) +" discount ");
					double balanceAfterPurchase =0;
					if(cus.getLoyaltyPoints()>20) {
						balanceAfterPurchase = (cus.getBalance()+(5*(cus.getLoyaltyPoints()/20))-selfCheck.getTotalamount());
						
					}else {
					balanceAfterPurchase = cus.getBalance()-selfCheck.getTotalamount();
					}
					System.out.println("Your balance after purchase is $"+ String.format("%.2f", balanceAfterPurchase));
					
				break;
			case 5:do {
				quit=staffLogin();
				}while(!quit);
					if(position.equals("salestaff")) {
					selfCheck.cancelPurchase();
					selfCheck.getShoppingCart();
				}
					customerMenu();
					systemMenu();		
				break;
			case 6:System.out.println("Exit for Self Check out System ");
				break;
			default:
					System.out.println("Please choose option 1, 2, 3, 4 or 5 only!");
					customerMenu();
			}
		}
		
		//display staff menu, take selection input and perform actions
		public  void staffMenu() {
			System.out.println("***Staff Only services***");
			System.out.println("");
			System.out.println("Please select your department:\n");
			System.out.println("1. Sales ");
			System.out.println("2. Warehouse ");
		
			int choice = in.nextInt();
			switch(choice) {
			//Case 1 leads to another Switch Case for Sales Employees
			case 1:
				System.out.println("What do you want to do?\n");
				System.out.println("1. Check Stock on Hand");
				System.out.println("2. Look up an item");
				System.out.println("3. Remove item");
				System.out.println("4. Cancel a transaction");
				System.out.println("5. Manage debit cards");
				
				int choose = in.nextInt();
				switch(choose) {
				case 1:
//					checkStock(Stock):void
					break;
				case 2:
//					lookUpItem():Product
					break;
				case 3:
//					removeItem()void
					break;
				case 4:
//					cancelTransaction():Boolean
					break;
				case 5:
//					checkIfCardExists(cardNumber):boolean
//					sellCompanyCard():void
//					addToArray(CreditCard):void
//					topUpCard(double):void
					break;
		
				default:
					System.out.println("Ooops, you didn't select a valid option, please try again!");
					staffMenu();
										
				}		
				break;
				
			case 2:
			    System.out.println("Check Product Stock");
//				checkStock(Stock);
				break;
				
				default:
					System.out.println("Please choose option 1 or 2 only!");
					staffMenu();
			}
		}
		
		//display manager menu, take selection input and perform actions
		public void managerMenu() {
				
				System.out.println("***Manager Only services***");
				System.out.println("");
				
				System.out.println("Check Stock on Hand: Press 1");
				System.out.println("Set Discount: Press 2");
				System.out.println("Add product to the order list: Press 3");
				System.out.println("Remove product to the order list: Press 4");
				System.out.println("Place the order: Press 5");
				System.out.println("Check Product Revenue: Press 6");
				System.out.println("Check Store Supplier Details: Press 7");
				System.out.println("Add a Supplier: Press 8");
				System.out.println("Remove a Supplier: Press 9");
				System.out.println("Exit program: Press 10");
			
				int choice = in.nextInt();
				
				switch(choice)
				{
				case 1:checkStock();
						managerMenu();
					break;
				case 2:System.out.println("Enter the product name or product ID :");
						 n = in.next();
						 p = searchProduct(n);
						System.out.println("Enter the percentage of discount :");
						double per = in.nextDouble();
						setDisPrice(p,per);
						managerMenu();
					break;
					
				case 3:System.out.println("Enter the product name or product ID :");
						 n = in.next();
						 p = selfCheck.searchProduct(n);
						System.out.println("Enter amout you want to order :");
						int a = in.nextInt();
						addOrder(p,a);
						System.out.println(p.getProductName()+" was added to the order list");
						managerMenu();
					break;

				case 4:System.out.println("Enter the product name or product ID :");
						 n = in.next();
						 p = selfCheck.searchProduct(n);
						 for(int i =0 ; i< orderList.getOrderList().size();i++) {
							 if(orderList.getOrderList().get(i).equals(p))
							 {
								 orderList.getOrderList().remove(i);
							 }
						 }
						
						 System.out.println(p.getProductName()+ " remove from the order list ");
						managerMenu();
					break;

				case 5:System.out.println("The order was been placed");
					managerMenu();
					break;

				case 6:createMostRevenueReport();
					managerMenu();
					break;

				case 7:System.out.println("Supplier Detail");
					showSupplierDetail();
					managerMenu();
					
					break;
					
				case 8:System.out.println("Enter a supplier detail");
					    System.out.println("Supplier detail add to list");
					    managerMenu();
					break;
				case 9:System.out.println("Enter a supplier Name");
			    		System.out.println("Supplier detail remove from list");
					managerMenu();
					break;
				case 10:
	
					break;	
				}
			}
		
		//display supplier information
		private void showSupplierDetail() {
			for(Supplier s:supplierlists) {
				System.out.println(s.toString());
			}	
		}

		public Product searchProduct(String name) { //return item and price; search by ID and by name
			 Product product = findProductID(name);
			System.out.println(product.getProductName() + "Price "+ product.getPrice()+
					" Bulk buy discout price $"+ product.getDiscountBulkBuyPrice()+ "Bulk buy amount :"+product.getItemNumDiscount()+
					" Promotion discount Price $"+ product.getDiscountPromotionPrice());
			return product;
		}
		
		//return product details
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
		
		//read user's menu input and perfom requested actions
		public void systemMenu() {
			menu();
			int choice = in.nextInt();
			switch(choice) {
			case 1:boolean check = true;
				do {
					check=customerlogin();
					}
					while(!check);
					customerMenu();
					break;
			case 2:do {
						quit=staffLogin();
					}while(!quit);
				switch(position) {
				case "manager": managerMenu();
					break;
				case "salestaff":staffMenu();
					break;
				case "warehousestaff":staffMenu();
					break;
				}
			break;	
			}	
		}

		//request customer login and verify accuracy
		private boolean customerlogin() {
			System.out.println("Please enter your customer ID or customer name ");
			String id = in.next();
			for(int i=0;i<customerList.size();i++) {
				if(customerList.get(i).getCusID().equals(id)||customerList.get(i).getCustomerName().equals(id)) {
					cus= customerList.get(i);
					return true;
				}
			}
			
			return false;

		}
}
		
