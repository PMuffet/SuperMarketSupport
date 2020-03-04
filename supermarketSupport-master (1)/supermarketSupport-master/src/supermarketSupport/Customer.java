package supermarketSupport;

public class Customer {
	private String cusID;
	public String getCusID() {
		return cusID;
	}

	public void setCusID(String cusID) {
		this.cusID = cusID;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	private String customerName;
	private String streetAddress;
	private String suburb;
	private String postcode;
	private int loyaltyPoints = 0;  //customers start with 0 loyalty points when debit card is purchased
	private CreditCard card = new CreditCard();
	private double balance;
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	//constructor for customers with a store debit card
	public Customer (String cusID,String customerName, String streetAddress, String suburb, String postcode, CreditCard card, int loyaltyPoints){
		this.cusID = cusID;
		this.customerName = customerName;
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.postcode = postcode;	
		this.card = card;
		this.loyaltyPoints = loyaltyPoints;
		balance=300;
	}
	
	//constructor for customers who have not purchased the store debit card yet  ???
	public Customer (String cusID,String customerName, String streetAddress, String suburb, String postcode){
		this.cusID = cusID;
		this.customerName = customerName;
		this.streetAddress = streetAddress;
		this.suburb = suburb;
		this.postcode = postcode;	
	}
	
	public Customer (String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getSuburb () {
		return suburb;
	}
	
	public void setSuburb (String suburb) {
		this.suburb = suburb;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) { 
		this.postcode = postcode;
	}
	

	public CreditCard getCard() {
		return card;
	}

	public int getLoyaltyPoints(){
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) { 
		this.loyaltyPoints = loyaltyPoints;
	}
}
