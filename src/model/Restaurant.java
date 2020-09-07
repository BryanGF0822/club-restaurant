package model;

public class Restaurant {
	
	private String name;
	private int nit;
	private String adminName;
	
	public Restaurant(String name, int nit, String adminName) {
		this.name = name;
		this.nit = nit;
		this.adminName = adminName;
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
	
	

}
