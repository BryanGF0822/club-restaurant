package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	private String name;
	private int nit;
	private String adminName;
	
	private List<Product> products;
	
	public Restaurant(String name, int nit, String adminName) {
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
	
	public int getNit() {
		return nit;
	}
	
	public void setNit(int nit) {
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
