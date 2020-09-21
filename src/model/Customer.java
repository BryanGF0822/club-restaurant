package model;

import java.io.Serializable;
import java.util.Comparator;

public class Customer implements Serializable, Comparable<Customer>{

	private IdentificationType typeOfId;
	private String idNumber;
	private String name;
	private String lastName;
	private String phoneNumber;
	private String address;

	public Customer(IdentificationType typeOfId, String idNumber, String name, String lastName, String phoneNumber,
			String address) {
		this.typeOfId = typeOfId;
		this.idNumber = idNumber;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public IdentificationType getTypeOfId() {
		return typeOfId;
	}

	public void setTypeOfId(IdentificationType typeOfId) {
		this.typeOfId = typeOfId;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer typeOfId: " + typeOfId + ", idNumber: " + idNumber + ", name: " + name + ", lastName: " + lastName
				+ ", phoneNumber: " + phoneNumber + ", address: " + address;
	}

	@Override
	public int compareTo(Customer o) {
		
		int cus = 0;
		if (o.getPhoneNumber().compareTo(getPhoneNumber()) < 0) {
			cus = 1;
		}else if (o.getPhoneNumber().compareTo(getPhoneNumber()) > 0) {
			cus = -1;
		}else {
			cus = 0;
		}
		return cus;
	}
	
	
}
