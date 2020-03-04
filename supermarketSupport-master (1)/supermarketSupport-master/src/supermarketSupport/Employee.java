package supermarketSupport;

public class Employee {
	
	private String name;
	private int age;
	private String empId;
	private String address;
	private String phoneNum;
	private String gender;
	private String positon;
	private String password;
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, String empId, String address, String phoneNum, String gender,
			String positon,String password) {
		this.name = name;
		this.age = age;
		this.empId = empId;
		this.address = address;
		this.phoneNum = phoneNum;
		this.gender = gender;
		this.positon = positon;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPositon() {
		return positon;
	}
	
	public void setPositon(String positon) {
		this.positon = positon;
	}
}
