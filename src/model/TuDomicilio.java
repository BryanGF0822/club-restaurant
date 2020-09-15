package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TuDomicilio implements Serializable {

	private List<Restaurant> restaurants;
	private List<Customer> customers;
	private List<Order> orders;

	public TuDomicilio() {

		restaurants = new ArrayList<Restaurant>();
		customers = new ArrayList<Customer>();
		orders = new ArrayList<Order>();
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void addRestaurant(String na, String ni, String admin) {

		Restaurant newRest = new Restaurant(na, ni, admin);
		restaurants.add(newRest);
	}

	public void addCustomer(IndentificationType typeOfId, String idN, String na, String lastNa, String phoneN,
			String addr) {
		
		Customer newCus = new Customer(typeOfId, idN, na, lastNa, phoneN, addr);
		customers.add(newCus);
	}
	
	public void addOrder() {
		
		int orderCode = 1000000 + (int)(Math.random()*9999999);
		Date dayAndTime = new Date();
	}

	public void addProduct(String co, String na, String descrip, double pri, String nitR) {

		boolean found = false;
		for (int i = 0; i < restaurants.size() && !found; i++) {

			if (restaurants.get(i).getNit().compareTo(nitR) == 0) {

				restaurants.get(i).addProduct(co, na, descrip, pri, nitR);
			}
		}
	}

}
