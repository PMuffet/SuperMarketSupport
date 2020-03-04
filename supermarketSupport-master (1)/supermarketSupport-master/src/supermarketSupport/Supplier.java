package supermarketSupport;

public class Supplier {
	private String supplierID;
	private String supplierName;
	private String supplierAddress;
	private String supplierPhone;
	
	public Supplier(String supplierID, String supplierName, String supplierAddress, String supplierPhone) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.supplierPhone = supplierPhone;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}
	
	
	@Override
	public String toString() {
		System.out.println();
		return "ID: " + supplierID + "\nName :"+ supplierName + "\nAddress :"+ supplierAddress + "\nPhone :" + supplierPhone;
	}
	
}
