package model;

public class Product {
	
	private int code;
	private String name;
	private String description;
	private int price;
	
	private int nitRestaurant;// ¿Dudas sobre como manejar esto?

	public Product(int code, String name, String description, int price) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
