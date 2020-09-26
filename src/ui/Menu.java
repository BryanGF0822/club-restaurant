package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Exception.IsEmptyException;
import Exception.TwoResWithSameNitR;
import model.IdentificationType;
import model.Order;
import model.StatusOrder;
import model.TuDomicilio;

public class Menu {

	public static final int EXIT = 14;

	private static Scanner sc;
	private static TuDomicilio tuDomi;

	public Menu() {

		sc = new Scanner(System.in);
		tuDomi = new TuDomicilio();
	}

	public void startMenu() {
		try {
			tuDomi = loadData();
			String menu = getMenuText();
			int option;

			do {
				System.out.println(menu);
				option = readOption();
				operation(option);
			} while (option != EXIT);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IsEmptyException e) {
			System.out.println(e.getMessage());
		}
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
		menu += "9. Import data of restaurant.\n";
		menu += "10. Import data of product.\n";
		menu += "11. Alphabetically ascending restaurant list\n";
		menu += "12. Phone Number descending customer list\n";
		menu += "13. Search a customer.\n";
		menu += "14. Exit\n";
		return menu;
	}

	private int readOption() {

		int op;
		op = Integer.parseInt(sc.nextLine());
		return op;
	}

	private void operation(int option) throws IsEmptyException {

		try {
			switch (option) {
			case 1:
				addRestaurant();
				saveData();
				break;

			case 2:
				addProduct();
				saveData();
				break;

			case 3:
				addCustomer();
				saveData();
				break;

			case 4:
				addOrder();
				saveData();
				break;

			case 5:
				updateRestaurant();
				saveData();
				break;

			case 6:
				updateProduct();
				saveData();
				break;

			case 7:
				updateCustomer();
				saveData();
				break;

			case 8:
				updateOrder();
				saveData();
				break;

			case 9:
				importDataRestaurant();
				break;
				
			case 10:
				importDataProduct();
				break;
				
			case 11:
				alphabeticallyAscendingRestaurant();
				break;

			case 12:
				phoneNumberDescending();
				break;

			case 13:
				searchCustomer();
				break;

			case 14:
				exitProgram();
				break;

			}
		} catch (NumberFormatException e) {
			System.out.println("Debes insertar un numero");
			sc.nextLine();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void exitProgram() throws IOException {
		sc.close();
	}

	private void addRestaurant() throws IsEmptyException {

		try {
			System.out.println("Adding new restaurant...");
			System.out.println("");
			System.out.println("Please type nema of restaurant:\n");
			String na = sc.nextLine();
			System.out.println("Please type nit of restaurant:\n");
			String ni = sc.nextLine();
			System.out.println("Please type administrator's name:\n");
			String admin = sc.nextLine();

			if (na.equals("") || ni.equals("") || admin.equals("")) {
				throw new IsEmptyException();
			}

			tuDomi.addRestaurant(na, ni, admin);
			System.out.println("Procesing...\n");
			System.out.println("Restaurant added correctly.");

//			for (int i = 0; i < tuDomi.getRestaurants().size(); i++) {
//				System.out.println(tuDomi.getRestaurants().get(i));
//			}
		} catch (IsEmptyException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}catch (TwoResWithSameNitR e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void updateRestaurant() throws IsEmptyException {
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

		if (nitR.equals("") || newNa.equals("") || newNitR.equals("") || newAdmin.equals("")) {
			throw new IsEmptyException();
		}
		
		tuDomi.updateRestaurant(nitR, newNa, newNitR, newAdmin);
		System.out.println("Data was updated correctly.");

//		for (int i = 0; i < tuDomi.getRestaurants().size(); i++) {
//			System.out.println(tuDomi.getRestaurants().get(i));
//		}
	}

	private void addProduct() throws IsEmptyException {
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

		if (co.equals("") || na.equals("") || descrip.equals("") || pri == 0 || nitR.equals("")) {
			throw new IsEmptyException();
		}
		
		tuDomi.addProduct(co, na, descrip, pri, nitR);
		System.out.println("Procesing...\n");
		System.out.println("Product added correctly.");
	}

	private void updateProduct() throws IsEmptyException {
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

		if (co.equals("") || newCo.equals("") || newNa.equals("") || newDescrip.equals("") || newPri == 0 || nitR.equals("")) {
			throw new IsEmptyException();
		}
		
		tuDomi.updateProduct(co, newCo, newNa, newDescrip, newPri, nitR);
		System.out.println("Data was updated correctly");

	}

	private void addCustomer() throws IsEmptyException {
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

		if (idN.equals("") || na.equals("") || lastNa.equals("") || phoneN.equals("") || addr.equals("")) {
			throw new IsEmptyException();
		}
		
		tuDomi.addCustomer(typeOfId, idN, na, lastNa, phoneN, addr);
		
		for (int i = 0; i < tuDomi.getCustomers().size(); i++) {
			System.out.println(tuDomi.getCustomers().get(i));
		}
	}

	private void updateCustomer() throws IsEmptyException {
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

		if (idN.equals("") || newIdN.equals("") || newNa.equals("") || newLastNa.equals("") || newPhoneN.equals("") || newAddr.equals("")) {
			throw new IsEmptyException();
		}
		
		tuDomi.updateCustomer(idN, newTofId, newIdN, newNa, newLastNa, newPhoneN, newAddr);
		System.out.println("Data was updated correctly.");
	}

	private void addOrder() throws IsEmptyException {
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

				if (orderCode.equals("") || trueCode.equals("") || nitRestaurantOrder.equals("") || quanty.equals("")) {
					throw new IsEmptyException();
				}
				
				tuDomi.addOrder(orderCode, dayAndTime, trueCode, nitRestaurantOrder, quanty, status, listPS);
			}
		}
	}

	private void updateOrder() {
		System.out.println("Please type code of order that you want to update:");
		String searchCode = sc.nextLine();
		int answer = 0;
		boolean found = false;
		List<Order> orders = tuDomi.getOrders();

		for (int i = 0; i < orders.size() && !found; i++) {
			if (orders.get(i).getCode().compareTo(searchCode) == 0) {
				if (orders.get(i).getStatus() == StatusOrder.SOLICITADO) {
					System.out.println("Select the new status:");
					System.out.println("1. En proceso.");
					System.out.println("2. Enviado.");
					System.out.println("3. Entregado");
					answer = Integer.parseInt(sc.nextLine());

					if (answer == 1) {
						orders.get(i).setStatus(StatusOrder.EN_PROCESO);
						System.out.println("The order was updated.");
					} else if (answer == 2) {
						orders.get(i).setStatus(StatusOrder.ENVIADO);
						System.out.println("The order was updated.");

					} else {
						orders.get(i).setStatus(StatusOrder.ENTREGADO);
						System.out.println("The order was updated.");

					}
				} else if (orders.get(i).getStatus() == StatusOrder.EN_PROCESO) {
					System.out.println("Select the new status:");
					System.out.println("1. Enviado.");
					System.out.println("2. Envtregado.");
					answer = Integer.parseInt(sc.nextLine());

					if (answer == 1) {
						orders.get(i).setStatus(StatusOrder.ENVIADO);
						System.out.println("The order was updated.");

					} else {
						orders.get(i).setStatus(StatusOrder.ENTREGADO);
						System.out.println("The order was updated.");

					}
				} else if (orders.get(i).getStatus() == StatusOrder.ENVIADO) {
					orders.get(i).setStatus(StatusOrder.ENTREGADO);
					System.out.println("The order was updated.");

				} else {
					System.out.println(
							"it is not possible to update the status of this loss because it was already delivered to the customer.");
				}
			}
			found = true;
		}
	}

	private void alphabeticallyAscendingRestaurant() {
		tuDomi.sortByNameRestaurant();
	}

	private void phoneNumberDescending() {
		tuDomi.sortByPhoneNumberOfCustomer();
	}

	private void searchCustomer() throws IsEmptyException {
		System.out.println("Please type name of customer that you want to search:");
		String searchName = sc.nextLine();
		
		if (searchName.equals("")) {
			throw new IsEmptyException();
		}
		
		long start = System.currentTimeMillis();
		tuDomi.searchCustomer(tuDomi.getCustomers(), searchName);
		long end = System.currentTimeMillis();

		System.out.println("start:" + start);
		System.out.println("end:" + end);
		System.out.println("Time of search: " + (end - start));
	}

	private static void importDataProduct() throws IOException {
		System.out.println("Please type nit restaurant that you want add list of products:");
		String nitR = sc.nextLine();
		String dataLink = "data/product.csv";

		tuDomi.importDataProduct(nitR, dataLink);
	}
	
	private static void importDataRestaurant() throws IOException {
		String dataLink = "data/restaurant.csv";
		tuDomi.importDataRestaurant(dataLink);
	}

	private static void saveData() throws IOException {

		File f = new File("data/datos.dat");
		if (f.exists() == false) {
			f.createNewFile();
		}

		ObjectOutputStream exportar = new ObjectOutputStream(new FileOutputStream(f));
		exportar.writeObject(tuDomi);
		exportar.close();

	}

	private static TuDomicilio loadData() throws FileNotFoundException, IOException, ClassNotFoundException {

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
