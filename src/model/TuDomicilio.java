package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Date;

@SuppressWarnings("serial")

/**
 * 
 */
public class TuDomicilio implements Serializable {

	private List<Restaurant> restaurants;
	private List<Customer> customers;
	private List<Order> orders;

	/**
	 * [TuDomicilio description]
	 * @return [description]
	 */
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

	/**
	 * [sortByNameRestaurant description]
	 */
	public void sortByNameRestaurant() {
		Comparator<Restaurant> acr = new AlphabeticallyAscendingRestaurantComparator();
		Collections.sort(restaurants, acr);
		
		for (int i = 0; i < restaurants.size(); i++) {
			System.out.println((i+1) + "" + restaurants.get(i) + ".");
		}
	}

	/**
	 * [sortByPhoneNumberOfCustomer description]
	 */
	public void sortByPhoneNumberOfCustomer() {
		Collections.sort(customers);
		
		for (int i = 0; i < customers.size(); i++) {
			System.out.println((i+1) + ". " + customers.get(i) + ".");
		}
		
	}

	/**
	 * [searchCustomer description]
	 * @param  customers  [description]
	 * @param  searchName [description]
	 * @return            [description]
	 */
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
	
	/**
	 * [addRestaurant description]
	 * @param na    [description]
	 * @param ni    [description]
	 * @param admin [description]
	 */
	public void addRestaurant(String na, String ni, String admin) {
		Restaurant newRest = new Restaurant(na, ni, admin);
		restaurants.add(newRest);
	}

	/**
	 * [updateRestaurant description]
	 * @param nitR     [description]
	 * @param newna    [description]
	 * @param newnitR  [description]
	 * @param newadmin [description]
	 */
	public void updateRestaurant(String nitR, String newna, String newnitR, String newadmin) {
		boolean found = false;
		for (int i = 0; i < restaurants.size() && !found; i++) {
			if (restaurants.get(i).getNit().compareTo(nitR) == 0) {
				restaurants.get(i).setName(newna);
				restaurants.get(i).setNit(newnitR);
				restaurants.get(i).setAdminName(newadmin);
				found = true;
			}
		}
	}

	/**
	 * [addCustomer description]
	 * @param typeOfId [description]
	 * @param idN      [description]
	 * @param na       [description]
	 * @param lastNa   [description]
	 * @param phoneN   [description]
	 * @param addr     [description]
	 */
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

	/**
	 * [updateCustomer description]
	 * @param idN       [description]
	 * @param newTofId  [description]
	 * @param newIdN    [description]
	 * @param newNa     [description]
	 * @param newLastNa [description]
	 * @param newPhoneN [description]
	 * @param newAddr   [description]
	 */
	public void updateCustomer(String idN, IdentificationType newTofId, String newIdN, String newNa, String newLastNa,
			String newPhoneN, String newAddr) {
		
		boolean found  =false;
		for (int i = 0; i < customers.size() && !found; i++) {
			if (customers.get(i).getIdNumber().compareTo(idN) == 0) {
				customers.get(i).setTypeOfId(newTofId);
				customers.get(i).setIdNumber(newIdN);
				customers.get(i).setName(newNa);
				customers.get(i).setLastName(newLastNa);
				customers.get(i).setPhoneNumber(newPhoneN);
				customers.get(i).setAddress(newAddr);
				
				found = true;
			}
		}
	}

	/**
	 * [addOrder description]
	 * @param co                [description]
	 * @param fecha_y_hora      [description]
	 * @param customerCode      [description]
	 * @param nitResProSelected [description]
	 * @param quantity          [description]
	 * @param status            [description]
	 * @param listPs            [description]
	 */
	public void addOrder(String co, Date fecha_y_hora, String customerCode, String nitResProSelected, String quantity, StatusOrder status, String listPs) {

		Order newOr = new Order(co, fecha_y_hora, customerCode, nitResProSelected, quantity, status, listPs);
		orders.add(newOr);
	}

	/**
	 * [addProduct description]
	 * @param co      [description]
	 * @param na      [description]
	 * @param descrip [description]
	 * @param pri     [description]
	 * @param nitR    [description]
	 */
	public void addProduct(String co, String na, String descrip, double pri, String nitR) {

		boolean found = false;
		for (int i = 0; i < restaurants.size() && !found; i++) {

			if (restaurants.get(i).getNit().compareTo(nitR) == 0) {

				restaurants.get(i).addProduct(co, na, descrip, pri, nitR);
				found = true;
			}
		}
	}

	/**
	 * [updateProduct description]
	 * @param co         [description]
	 * @param newCo      [description]
	 * @param newNa      [description]
	 * @param newDescrip [description]
	 * @param newPri     [description]
	 * @param nitR       [description]
	 */
	public void updateProduct(String co, String newCo, String newNa, String newDescrip, double newPri, String nitR) {
		
		boolean found = false;
		for (int i = 0; i < restaurants.size() && !found; i++) {

			if (restaurants.get(i).getNit().compareTo(nitR) == 0
					&& restaurants.get(i).updateProductConfirmation(co) == true) {

				restaurants.get(i).getProducts().get(i).setCode(newCo);
				restaurants.get(i).getProducts().get(i).setName(newNa);
				restaurants.get(i).getProducts().get(i).setDescription(newDescrip);
				restaurants.get(i).getProducts().get(i).setPrice(newPri);
				
				found = true;
			}
		}
	}
	
	public void importDataRestaurant(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(" ");			
			Restaurant restau = new Restaurant(split[0], split[1], split[3]);
			restaurants.add(restau);
			line = br.readLine();
			
		}
	}
	
	public void importDataCustomer(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(" ");			
			Customer custo = new Customer(IdentificationType.valueOf(split[0]), split[1], split[2], split[3], split[4], split[5]);
			customers.add(custo);
			line = br.readLine();
			
		}
	}
	
	public void importDataOrder(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(" ");			
			Order or = new 	Order(split[0], java.sql.Date.valueOf(split[1]), split[2], split[3], split[4], StatusOrder.valueOf(split[5]), split[6]) ;
			orders.add(or);
			line = br.readLine();
			
		}
	}

}
