package supermarketSupport;

public class OrderLine {
	private Product product;
	private int amount;
	public OrderLine(Product product,int amount) {
		this.product=product;
		this.amount=amount;
	}
	
	public double calculatePrice() {
		return product.getSupplierPrice()*amount;
	}

	public Product getProduct() {
		return product;
	}

	public int getAmount() {
		return amount;
	}
}
