package model;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Product implements Serializable{
	
	private String code;
	private String name;
	private String description;
	private double price;
	private String nitRestaurant;
	
	/**
	 * [Product: Method of construction of a product]
	 * @param  code          [Code of product]
	 * @param  name          [Name of product]
	 * @param  description   [little description of product]
	 * @param  price         [cost to order this product]
	 * @param  nitRestaurant [nit of restaurant that sells this product]
	 * @return               [object product with all their attributes ]
	 */
	public Product(String code, String name, String description, double price, String nitRestaurant) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.nitRestaurant = nitRestaurant;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNitRestaurant() {
		return nitRestaurant;
	}

	public void setNitRestaurant(String nitRestaurant) {
		this.nitRestaurant = nitRestaurant;
	}

	/**
	 * [toString: Method of construction of a product]
	 * @return [String with all attributes in text format]
	 */
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", nitRestaurant=" + nitRestaurant + "]";
	}
	
	
	
}
