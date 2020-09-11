package model;

public class Customer {

	private IndentificationType typeOfId;
	private int idNumber;
	private String name;
	private String lastName;
	private int phoneNumber;
	private String address;

	public Customer(IndentificationType typeOfId, int idNumber, String name, String lastName, int phoneNumber,
			String address) {
		this.typeOfId = typeOfId;
		this.idNumber = idNumber;
		this.name = name;
		this.lastName = lastName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
