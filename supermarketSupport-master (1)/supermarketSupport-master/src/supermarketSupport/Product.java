package supermarketSupport;

public class Product {
	
	private String productID;
	private String productName;
	private double price;
	private int quantity;
	private double discountPromotionPrice;
	private double discountBulkBuyPrice;
	private int replenishLevel;
	private int itemNumDiscount;		
	private double discountPer=10;
	private double totalSale;
	private int totalSaleAmount;
	private double supplierPrice;
	private Supplier supplier;
	public int getTotalSaleAmount() {
		return totalSaleAmount;
	}

	public void setTotalSaleAmount(int totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}

	public Product(String productID,String productName, double price, int quantity,int replenishLevel,double supplierPrice,Supplier supplier) {
		this.productID=productID;
		this.productName = productName;
		this.productID = productID;
		this.price = price;
		this.quantity = quantity;
		this.replenishLevel=replenishLevel;
		this.supplierPrice=supplierPrice;
		this.discountPromotionPrice = 0;
		this.supplier=supplier;
		itemNumDiscount=10;
		discountBulkBuyPrice = price * (1-(discountPer/100));
	}
	
	public double getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(double supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	public double getDiscountPromotionPrice() {
		return discountPromotionPrice;
	}

	public void setDiscountPromotionPrice(double discountPromotionPrice) {
		this.discountPromotionPrice = discountPromotionPrice;
	}

	public double getDiscountBulkBuyPrice() {
		return discountBulkBuyPrice;
	}

	public void setDiscountBulkBuyPrice(double discountBulkBuyPrice) {
		this.discountBulkBuyPrice = discountBulkBuyPrice;
	}

	public Product(String productName, String productID, double price, int quantity, double discountPrice,
			int replenishLevel, int itemNumDiscount) {
		this.productName = productName;
		this.productID = productID;
		this.price = price;
		this.quantity = quantity;
		this.discountPromotionPrice = discountPrice;
		this.replenishLevel = replenishLevel;
		this.itemNumDiscount = itemNumDiscount;
		discountBulkBuyPrice = price * (discountPer/100);
	}
	
	public double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(double totolSale) {
		this.totalSale = totolSale;
	}

	public int getItemNumDiscount() {
		return itemNumDiscount;
	}

	public void setItemNumDiscount(int itemNumDiscount) {
		this.itemNumDiscount = itemNumDiscount;
	}

	public int getReplenishLevel() {
		return replenishLevel;
	}

	public void setReplenishLevel(int replenishLevel) {
		this.replenishLevel = replenishLevel;
	}

	public double getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(int discountPer) {
		this.discountPer = discountPer;
	}


	public double getDiscountPrice() {
		return discountPromotionPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPromotionPrice = discountPrice;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void AfterSaleAmount(int amount) {
		quantity -=amount;
	}
	
	public String printDetails() { //Liz
		return "Product ID: " + productID + " Product name: " + productName + "\n" + "Price: " + price+": Total sell amount : "+totalSaleAmount+" total sell : "+totalSale+" discountprice: "+discountPromotionPrice ;
	}
}
