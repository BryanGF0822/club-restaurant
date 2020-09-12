package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
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
	
	

}
