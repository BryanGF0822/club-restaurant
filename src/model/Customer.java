package model;

public class Customer {
	
	private IndentificationType typeOfId;
	private int idNumber;
	private String fullName;
	private int phoneNumber;
	private String address;
	
	public Customer(IndentificationType typeOfId, int idNumber, String fullName, int phoneNumber, String address) {
		this.typeOfId = typeOfId;
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public IndentificationType getTypeOfId() {
		return typeOfId;
	}

	public void setTypeOfId(IndentificationType typeOfId) {
		this.typeOfId = typeOfId;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
