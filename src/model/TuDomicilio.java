package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public void imprimir() {
		String salida = "";
		for (int i = 0; i < restaurants.size(); i++) {
			salida += restaurants.get(i).getName();
			salida += restaurants.get(i).getNit();
			salida += restaurants.get(i).getAdminName();
		}
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
		customers.add(newCus);
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
