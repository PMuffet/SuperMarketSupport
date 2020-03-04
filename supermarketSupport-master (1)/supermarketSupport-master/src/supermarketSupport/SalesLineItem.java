package supermarketSupport;

public class SalesLineItem {
	
	private Product product;
	private String productName;
	private int amount;
	private double total;
	private double totalSale;
	private int totalamount;
	private DateTime date;
	
	public SalesLineItem(Product product,int amount) {
		super();
		this.product = product;
		productName=product.getProductName();
		this.amount=amount;
		date = new DateTime();
	}
	
	public double calculateSale() {
		if(amount>product.getItemNumDiscount()&& product.getItemNumDiscount()>01) {
			total =product.getDiscountBulkBuyPrice()*amount;
		}else
		{
			total =product.getPrice()*amount;
		}
		totalSale=total+product.getTotalSale();
		product.setTotalSale(totalSale);
		product.AfterSaleAmount(amount);
		totalamount = product.getTotalSaleAmount();
		totalamount += amount;
		product.setTotalSaleAmount(totalamount);
		return total;	
	}
	
	public double getTotal() {
		return total;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getTotalamount() {
		return totalamount;
	}
	
	public String getProductName() {
		return productName;
	}

	public double getTotalSale() {
		return total;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount=amount;
	}
	
	public DateTime getDate() {
		return date;
	}
	
	public void setDate(DateTime date) {
		this.date = date;
	}
}
