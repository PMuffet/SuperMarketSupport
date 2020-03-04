package supermarketSupport;

import java.util.ArrayList;

public class Order {
	ArrayList<OrderLine> orderList;
	int  amount;
	DateTime date;
	public Order() {
		orderList = new ArrayList<>();
		date = new DateTime();
	}
	
	public void addProductToOrder(Product product,int amount) {
		OrderLine orderline = new OrderLine(product,amount);
		if(!orderList.contains(orderline)) {
		orderList.add(orderline);
		}
	}
	
	public ArrayList<OrderLine> getOrderList(){
		return orderList;
	}
	
	public void showOrderList() {
		for(OrderLine o:orderList) {
			System.out.println(o.getProduct().getProductName()+" Amount "+ o.getAmount() + " on order "+ " total :"+o.calculatePrice() );
		}
	}
}
