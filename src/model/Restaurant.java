package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Restaurant implements Serializable {
	
	private String name;
	private String nit;
	private String adminName;
	
	private List<Product> products;
	
	public Restaurant(String name, String nit, String adminName) {
		this.name = name;
		this.nit = nit;
		this.adminName = adminName;
		
		products = new ArrayList<Product>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void addProduct(String co, String na, String descrip, double pri, String nitR) {
		
		Product newprod = new Product(co, na, descrip, pri, nitR);
		products.add(newprod);
	}
	
	public boolean updateProductConfirmation(String co) {
		
		boolean found = false;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCode().compareTo(co) == 0) {
				found = true;
			}
		}
		return found;
	}

	@Override
	public String toString() {
		return "Restaurant name: " + name + ", Nit: " + nit + ", AdminName:" + adminName + "\n";
	}

}
