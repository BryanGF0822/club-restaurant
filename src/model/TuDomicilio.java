package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void sortByNameRestaurant() {
		Comparator<Restaurant> acr = new AlphabeticallyAscendingRestaurantComparator();
		Collections.sort(restaurants, acr);
		
		for (int i = 0; i < restaurants.size(); i++) {
			System.out.println((i+1) + "" + restaurants.get(i) + "");
		}
	}
	
	public Customer searchCustomer(List<Customer> customers, String searchName) {
		int max = customers.size() - 1;
		int min = 0;
		int half = 0;
		int position = -1;
		
		while(position == -1 && min <= max) {
			half = (min + max)/2;
			if (customers.get(half).getName() == searchName) {
				position = half;
			}else if (customers.get(half).getName().compareTo(searchName) < 0) {
				min = half + 1;
			}else {
				max = half -1;
			}
		}
		return customers.get(position);
				
	}
	

	public void addRestaurant(String na, String ni, String admin) {
		Restaurant newRest = new Restaurant(na, ni, admin);
		restaurants.add(newRest);
	}

	public void updateRestaurant(String nitR, String newna, String newnitR, String newadmin) {
		boolean found = false;
		for (int i = 0; i < restaurants.size() && !found; i++) {
			if (restaurants.get(i).getNit().compareTo(nitR) == 0) {
				restaurants.get(i).setName(newna);
				restaurants.get(i).setNit(newnitR);
				restaurants.get(i).setAdminName(newadmin);
			}
		}
	}

	public void addCustomer(IdentificationType typeOfId, String idN, String na, String lastNa, String phoneN,
			String addr) {

		Customer newCus = new Customer(typeOfId, idN, na, lastNa, phoneN, addr);
		lastNameAndNameComparator landN = new lastNameAndNameComparator();
		boolean found = false;
		for (int i = 0; i < customers.size() && !found; i++) {
			
			if (landN.compare(newCus, customers.get(i)) < 0) {
				customers.add(i, newCus);
				found = true;
			}
		}
	}

	public void updateCustomer(String idN, IdentificationType newTofId, String newIdN, String newNa, String newLastNa,
			String newPhoneN, String newAddr) {

		boolean found = false;
		for (int i = 0; i < customers.size(); i++) {

			if (customers.get(i).getIdNumber().compareTo(idN) == 0) {
				customers.get(i).setTypeOfId(newTofId);
				customers.get(i).setIdNumber(newIdN);
				customers.get(i).setName(newNa);
				customers.get(i).setLastName(newLastNa);
				customers.get(i).setPhoneNumber(newPhoneN);
				customers.get(i).setAddress(newAddr);
			}
		}
	}

	public void addOrder() {

		int orderCode = 1000000 + (int) (Math.random() * 9999999);
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

	public void updateProduct(String co, String newCo, String newNa, String newDescrip, double newPri, String nitR) {

		boolean found = false;
		for (int i = 0; i < restaurants.size(); i++) {

			if (restaurants.get(i).getNit().compareTo(nitR) == 0
					&& restaurants.get(i).updateProductConfirmation(co) == true) {

				restaurants.get(i).getProducts().get(i).setCode(newCo);
				restaurants.get(i).getProducts().get(i).setName(newNa);
				restaurants.get(i).getProducts().get(i).setDescription(newDescrip);
				restaurants.get(i).getProducts().get(i).setPrice(newPri);
			}
		}
	}

}
