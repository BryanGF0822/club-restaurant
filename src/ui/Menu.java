package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import model.IdentificationType;
import model.TuDomicilio;

public class Menu {

	public static final int EXIT = 7;

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
		menu += "4. Update a restaurant.\n";
		menu += "5. Update a product.\n";
		menu += "6. Update a Customer.\n";
		menu += "7. Exit\n";
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
			break;

		case 2:
			addProduct();
			break;

		case 3:
			addCustomer();
			break;

		case 4:
			updateRestaurant();
			break;
			
		case 5:
			updateProduct();
			break;
			
		case 6:
			updateCustomer();
			break;
			
		case 7:
			exitProgram();
			break;

		case 8:
			break;

		}
	}

	private void exitProgram() throws IOException {
		sc.close();
		guardarDatos();
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
