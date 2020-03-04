package supermarketSupport;

import java.util.Scanner;

public class CreditCard {

	private String cardNumber;
	private String expiryDate;
	private String nameOnCard;
	private double cardBalance;
	Scanner input = new Scanner(System.in);
	
	public CreditCard (String cardNumber, String expiryDate, String nameOnCard, double cardBalance) {
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.nameOnCard = nameOnCard;
		this.cardBalance = cardBalance;
	}
	
	public CreditCard() {
		cardBalance = 100;	
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	
	public double getCardBalance() {
		return cardBalance;
	}
	
	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}
} 
	
