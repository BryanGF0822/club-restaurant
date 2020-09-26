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

import Exception.TwoResWithSameNitR;

import java.util.Date;

@SuppressWarnings("serial")

public class TuDomicilio implements Serializable {

	private List<Restaurant> restaurants;
	private List<Customer> customers;
	private List<Order> orders;

	/**
	 * [TuDomicilio: Main class of the model, in charge of managing all the income to the other classes of the model.
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
	 * [sortByNameRestaurant: Sorting algorithm by restaurant name]
	 */
	public void sortByNameRestaurant() {
		Comparator<Restaurant> acr = new AlphabeticallyAscendingRestaurantComparator();
		Collections.sort(restaurants, acr);
		
		for (int i = 0; i < restaurants.size(); i++) {
			System.out.println((i+1) + "" + restaurants.get(i) + ".");
		}
	}

	/**
	 * [sortByPhoneNumberOfCustomer: Sorting algorithm by restaurant name]
	 */
	public void sortByPhoneNumberOfCustomer() {
		Collections.sort(customers);
		
		for (int i = 0; i < customers.size(); i++) {
			System.out.println((i+1) + ". " + customers.get(i) + ".");
		}
		
	}

	/**
	 * [searchCustomer: Efficient search method for when a customer is needed.]
	 * @param  customers  [customers list]
	 * @param  searchName [name of customer found]
	 * @return            [return the customer y the position found           S]
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
	 * [addRestaurant: Method that allows you to add a restaurant to the list.]
	 * @param na    [name of restaurant you would like to add to the list.]
	 * @param ni    [conteins nit of this new restaurant ]
	 * @param admin [name of admin the new restaurant]
	 * @throws TwoResWithSameNitR is impossible that 
	 */
	public void addRestaurant(String na, String ni, String admin) throws TwoResWithSameNitR {
		Restaurant newRest = new Restaurant(na, ni, admin);
		for (int i = 0; i < restaurants.size(); i++) {
			if (restaurants.get(i).getNit().compareTo(ni) == 0) {
				throw new TwoResWithSameNitR();
			}
		}
		restaurants.add(newRest);
	}

	/**
	 * [updateRestaurant: Method that allows you to add a restaurant to the list.]
	 * @param nitR     [nit of restaurant that you want to update]
	 * @param newna    [the new name that you change the actual name]
	 * @param newnitR  [the new code that you want change]
	 * @param newadmin [the new admin name to the new administration area]
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
	 * [addCustomer :method in charge of adding a client to the corresponding list.]
	 * @param typeOfId [type of identification to the customer]
	 * @param idN      [number of id to de customer]
	 * @param na       [name of custom that you want to add]
	 * @param lastNa   [name to the customer that you want to add]
	 * @param phoneN   [phone number to the customer addeed]
	 * @param addr     [address with location to the customer]
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
	 * [updateCustomer: method in charge of updating all customer data. ]
	 * @param idN       [the actual idN to search if this customer exist]
	 * @param newTofId  [new type of id to change the actual name]
	 * @param newIdN    [new id number to change the actual name]
	 * @param newNa     [new name to change the actual name]
	 * @param newLastNa [new last name to change the actual name]
	 * @param newPhoneN [A little description of the change the actual]
	 * @param newAddr   [addess to change the actual customer]
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

	public void addOrder(String co, Date fecha_y_hora, String customerCode, String nitResProSelected, String quantity, StatusOrder status, String listPs) {

		Order newOr = new Order(co, fecha_y_hora, customerCode, nitResProSelected, quantity, status, listPs);
		orders.add(newOr);
	}

	/**
	 * [addProduct: method of adding an product to the list.]
	 * @param co      [code of product]
	 * @param na      [name of product]
	 * @param descrip [description of product]
	 * @param pri     [price or value option]
	 * @param nitR    [nitR to the restaurant that have this product]
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
	 * [updateProduct: Method of updating products in a list]
	 * @param co         [the code of product]
	 * @param newCo      [new code of product to change the actual code]
	 * @param newNa      [new name to change the actual name]
	 * @param newDescrip [new description to change the actual]
	 * @param newPri     [new price to change to the actual]
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
			String[] split = line.split(",");			
			Restaurant restau = new Restaurant(split[0], split[1], split[2]);
			restaurants.add(restau);
			line = br.readLine();
			
		}
	}
	
	/**
	 * method in charge of importing product data from a csv file that will be read as flat files to generate products.
	 * @param nitR nit restauranto where de program find to search de file
	 * @param fn link of data
	 * @throws IOException
	 */
	public void importDataProduct(String nitR, String fn) throws IOException {
		boolean found = false;
		for (int i = 0; i < restaurants.size() && !found; i++) {
			if (restaurants.get(i).getNit().compareTo(nitR) == 0) {
				restaurants.get(i).importDataProduct(fn);
			}
		}
	}
	
	public void importDataCustomer(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(",");			
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
			String[] split = line.split(",");			
			Order or = new 	Order(split[0], java.sql.Date.valueOf(split[1]), split[2], split[3], split[4], StatusOrder.valueOf(split[5]), split[6]) ;
			orders.add(or);
			line = br.readLine();
			
		}
	}
	
//	public void exportDangerousBillboardReport(String fn) throws IOException {
//
//		String s = "";
//		File fl = new File("data/dangerousBillboards");
//		BufferedWriter br = new BufferedWriter(new FileWriter(fl));
//		s += "==========================\n";
//		s += "DANGEROUS BILLBOARDS REPORT\n";
//		s += "==========================\n";
//		s += "\n";
//		s += "The dangerous billboards are:\n";
//
//		int num = 1;
//
//		for (int i = 0; i < billboards.size(); i++) {
//			/*
//			 * siendo i = 0; i++ : i = i + 1; i = 1 i+1; i=0
//			 */
//			if (billboards.get(i).CalculateArea() >= 160000) {
//				s += num + "Billboard" + billboards.get(i).getBrand() + " with area "
//						+ billboards.get(i).CalculateArea()+"\n";
//				num += 1;
//			}
//		}
//		br.write(s);
//		br.close();
//	}

}
