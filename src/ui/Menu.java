package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.IdentificationType;
import model.Order;
import model.StatusOrder;
import model.TuDomicilio;

public class Menu {

	public static final int EXIT = 12;

	private Scanner sc;
	private static TuDomicilio tuDomi;

	public Menu() {

		sc = new Scanner(System.in);
		tuDomi = new TuDomicilio();
	}

	public void startMenu() throws FileNotFoundException, ClassNotFoundException, IOException {
		tuDomi = cargarDatos();
		String menu = getMenuText();
		int option;

		do {
			System.out.println(menu);
			option = readOption();
			operation(option);
		} while (option != EXIT);
	}

	private String getMenuText() {
		String menu;
		menu = "================================================\n";
		menu += "        WELCOME TO CLUB-RESTAURANT\n";
		menu += "   The place of your favorite restaurants.\n";
		menu += "================================================\n";
		menu += "\n";
		menu += "1. Add a new restaurant.\n";
		menu += "2. Add a new product\n";
		menu += "3. Add a new customer\n";
		menu += "4. Make an order.\n";
		menu += "5. Update a restaurant.\n";
		menu += "6. Update a product.\n";
		menu += "7. Update a Customer.\n";
		menu += "8. Update an order.\n";
		menu += "9. Alphabetically ascending restaurant list\n";
		menu += "10. Phone Number descending customer list\n";
		menu += "11. Search a customer.\n";
		menu += "12. Exit\n";
		return menu;
	}

	private int readOption() {

		int op;
		op = Integer.parseInt(sc.nextLine());
		return op;
	}

	private void operation(int option) throws IOException {

		switch (option) {
		case 1:
			addRestaurant();
			guardarDatos();
			break;

		case 2:
			addProduct();
			guardarDatos();
			break;

		case 3:
			addCustomer();
			guardarDatos();
			break;

		case 4:
			break;

		case 5:
			updateRestaurant();
			guardarDatos();
			break;

		case 6:
			updateProduct();
			guardarDatos();
			break;

		case 7:
			updateCustomer();
			guardarDatos();
			break;

		case 8:
			break;

		case 9:
			alphabeticallyAscendingRestaurant();
			break;

		case 10:
			phoneNumberDescending();
			break;

		case 11:
			searchCustomer();
			break;

		case 12:
			exitProgram();
			break;

		}
	}

	private void exitProgram() throws IOException {
		sc.close();
	}

	private void addRestaurant() {
		System.out.println("Adding new restaurant...");
		System.out.println("");
		System.out.println("Please type nema of restaurant:\n");
		String na = sc.nextLine();
		System.out.println("Please type nit of restaurant:\n");
		String ni = sc.nextLine();
		System.out.println("Please type administrator's name:\n");
		String admin = sc.nextLine();

		tuDomi.addRestaurant(na, ni, admin);
		System.out.println("Procesing...\n");
		System.out.println("Restaurant added correctly.");

		for (int i = 0; i < tuDomi.getRestaurants().size(); i++) {
			System.out.println(tuDomi.getRestaurants().get(i));
		}
	}

	private void updateRestaurant() {
		System.out.println("Loading...");
		System.out.println("");
		System.out.println("please type the nit restaurant that you want to update:");
		String nitR = sc.nextLine();
		System.out.println("Please type the new name of restaurant:");
		String newNa = sc.nextLine();
		System.out.println("Please type the new nit of restaurant:");
		String newNitR = sc.nextLine();
		System.out.println("Please type the admin name of restaurant:");
		String newAdmin = sc.nextLine();

		tuDomi.updateRestaurant(nitR, newNa, newNitR, newAdmin);
		System.out.println("Data was updated correctly.");

		for (int i = 0; i < tuDomi.getRestaurants().size(); i++) {
			System.out.println(tuDomi.getRestaurants().get(i));
		}
	}

	private void addProduct() {
		System.out.println("Adding new product...");
		System.out.println("");
		System.out.println("Please type code of product: ");
		String co = sc.nextLine();
		System.out.println("Please type name of product: ");
		String na = sc.nextLine();
		System.out.println("Please type a description of product: ");
		String descrip = sc.nextLine();
		System.out.println("Please type the cost of product: ");
		double pri = Double.parseDouble(sc.nextLine());
		System.out.println("Please type the Nit of restaurant: ");
		String nitR = sc.nextLine();

		tuDomi.addProduct(co, na, descrip, pri, nitR);
		System.out.println("Procesing...\n");
		System.out.println("Product added correctly.");
	}

	private void updateProduct() {
		System.out.println("Loading...");
		System.out.println("");
		System.out.println("Please type the code of product that you want to update:");
		System.out.println("");
		String co = sc.nextLine();
		System.out.println("Please type the new code of product:");
		String newCo = sc.nextLine();
		System.out.println("Please type the new name of product:");
		String newNa = sc.nextLine();
		System.out.println("Please type a new description of product:");
		String newDescrip = sc.nextLine();
		System.out.println("Please type the new price of product:");
		double newPri = Double.parseDouble(sc.nextLine());
		System.out.println("Please type the nit of the restaurant where this product belongs:");
		String nitR = sc.nextLine();

		tuDomi.updateProduct(co, newCo, newNa, newDescrip, newPri, nitR);
		System.out.println("Data was updated correctly");

	}

	public void addCustomer() {
		System.out.println("Adding new customer...");
		System.out.println("");
		System.out.println("Please select your identification type:");
		System.out.println("1. Cedula de ciudadania.");
		System.out.println("2. Tarjeta de identidad.");
		System.out.println("3. Cedula de extranjeria.");
		System.out.println("4. Pasaporte");

		int op = 0;
		op = Integer.parseInt(sc.nextLine());

		IdentificationType typeOfId = null;

		if (op == 1) {
			typeOfId = IdentificationType.CEDULA_DE_CIUDADANIA;
		} else if (op == 2) {
			typeOfId = IdentificationType.TARJETA_DE_IDENTIDAD;
		} else if (op == 3) {
			typeOfId = IdentificationType.CEDULA_DE_EXTRANJERIA;
		} else {
			typeOfId = IdentificationType.PASAPORTE;
		}

		System.out.println("Please type your id number:");
		String idN = sc.nextLine();
		System.out.println("Please type your name:");
		String na = sc.nextLine();
		System.out.println("Please type your last name:");
		String lastNa = sc.nextLine();
		System.out.println("Please type your phone number:");
		String phoneN = sc.nextLine();
		System.out.println("Please type your address :");
		String addr = sc.nextLine();

		tuDomi.addCustomer(typeOfId, idN, na, lastNa, phoneN, addr);
	}

	private void updateCustomer() {
		System.out.println("Loading...");
		System.out.println("");
		System.out.println("Please type the id number to the customer that you want to update:");
		String idN = sc.nextLine();
		System.out.println("Please select identification type:");
		System.out.println("1. Cedula de ciudadania.");
		System.out.println("2. Tarjeta de identidad.");
		System.out.println("3. Cedula de extranjeria.");
		System.out.println("4. Pasaporte");

		int op = 0;
		op = Integer.parseInt(sc.nextLine());

		IdentificationType newTofId = null;

		if (op == 1) {
			newTofId = IdentificationType.CEDULA_DE_CIUDADANIA;
		} else if (op == 2) {
			newTofId = IdentificationType.TARJETA_DE_IDENTIDAD;
		} else if (op == 3) {
			newTofId = IdentificationType.CEDULA_DE_EXTRANJERIA;
		} else {
			newTofId = IdentificationType.PASAPORTE;
		}

		System.out.println("Please type your id number:");
		String newIdN = sc.nextLine();
		System.out.println("Please type your name:");
		String newNa = sc.nextLine();
		System.out.println("Please type your last name:");
		String newLastNa = sc.nextLine();
		System.out.println("Please type your phone number:");
		String newPhoneN = sc.nextLine();
		System.out.println("Please type your address:");
		String newAddr = sc.nextLine();

		tuDomi.updateCustomer(idN, newTofId, newIdN, newNa, newLastNa, newPhoneN, newAddr);
		System.out.println("Data was updated correctly.");
	}

	public void addOrder() {
		System.out.println("Please type your customer id number:");
		String idCo = sc.nextLine();

		for (int i = 0; i < tuDomi.getCustomers().size(); i++) {
			if (tuDomi.getCustomers().get(i).getIdNumber() == idCo) {

				String orderCode = 1000000 + (int) (Math.random() * 9999999) + "";
				Date dayAndTime = new Date();
				String trueCode = idCo;
				StatusOrder status = StatusOrder.SOLICITADO;

				String listR = "";
				for (int j = 0; j < tuDomi.getRestaurants().size(); j++) {
					listR += (j + 1) + ". " + tuDomi.getRestaurants().get(j).getName() + "\n";
				}
				System.out.println(listR);

				System.out.println("Please Select a restaurant when you want to order:");
				int restaurantNumber = Integer.parseInt(sc.nextLine());

				String nitRestaurantOrder = tuDomi.getRestaurants().get(restaurantNumber - 1).getNit();

				String listP = "";
				for (int j = 0; j < tuDomi.getRestaurants().get(restaurantNumber - 1).getProducts().size(); j++) {
					listP += (j + 1) + ". "
							+ tuDomi.getRestaurants().get(restaurantNumber - 1).getProducts().get(j).getName();
				}

				boolean noMore = false;
				String listPS = "";
				String quanty = "";
				while (!noMore) {
					System.out.println(listP);
					System.out.println("Please select a product that you want to add to the order:");
					int selectedProduct = Integer.parseInt(sc.nextLine());
					System.out.println("Please type quantity product you want to order:");
					quanty = sc.nextLine();

					listPS += "Order: " + "Restaurant: "
							+ tuDomi.getRestaurants().get(restaurantNumber - 1).getProducts().get(selectedProduct - 1)
									.getName()
							+ "Product: " + tuDomi.getRestaurants().get(restaurantNumber - 1).getProducts()
									.get(selectedProduct - 1).getCode()
							+ "Quantity: " + quanty + "\n";

					System.out.println("Do you want to add another product?");
					System.out.println("1. Yes.");
					System.out.println("2. No");
					int answer = Integer.parseInt(sc.nextLine());
					if (answer == 2) {
						noMore = true;
					}

				}

				tuDomi.addOrder(orderCode, dayAndTime, trueCode, nitRestaurantOrder, quanty, status, listPS);
			}
		}
	}
	
	private void updateOrder() {
		System.out.println("Please type code of order that you want to update:");
		String searchCode = sc.nextLine();
		List<Order> orders = tuDomi.getOrders();
		
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getCode().compareTo(searchCode) == 0) {
				tuDomi.updateOrder();
			}
		}
	}

	public void alphabeticallyAscendingRestaurant() {
		tuDomi.sortByNameRestaurant();
	}

	public void phoneNumberDescending() {
		tuDomi.sortByPhoneNumberOfCustomer();
	}

	public void searchCustomer() {
		System.out.println("Please type name of customer that yu want to search:");
		String searchName = sc.nextLine();

		long start = System.currentTimeMillis();
		tuDomi.searchCustomer(tuDomi.getCustomers(), searchName);
		long end = System.currentTimeMillis();

		System.out.println("start:" + start);
		System.out.println("end:" + end);
		System.out.println("Time of search: " + (end - start));
	}

	private static void guardarDatos() throws IOException {

		File f = new File("data/datos.dat");
		if (f.exists() == false) {
			f.createNewFile();
		}

		ObjectOutputStream exportar = new ObjectOutputStream(new FileOutputStream(f));
		exportar.writeObject(tuDomi);
		exportar.close();

	}

	private static TuDomicilio cargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {

		TuDomicilio td = null;
		File f = new File("data/datos.dat");
		if (f.exists() == true) {
			ObjectInputStream importar = new ObjectInputStream(new FileInputStream(f));
			td = (TuDomicilio) importar.readObject();
			importar.close();
		} else {
			td = new TuDomicilio();
		}
		return td;
	}
}
