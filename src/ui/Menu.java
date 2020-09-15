package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import model.IndentificationType;
import model.TuDomicilio;

public class Menu {

	public static final int EXIT = 5;

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
		menu += "1. Add a new Restaurant.\n";
		menu += "2. \n";
		menu += "3. \n";
		menu += "4. \n";
		menu += "5. Exit\n";
		return menu;
	}

	private int readOption() {

		int op;
		op = Integer.parseInt(sc.nextLine());
		return op;
	}

	private void operation(int option) throws IOException {

		switch (option) {
		case 1: addRestaurant();

			break;

		case 2: addProduct();

			break;

		case 3:

			break;

		case 4:

			break;

		case 5: exitProgram();

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
		
		IndentificationType typeOfId = null;
		
		if (op == 1) {
			typeOfId = IndentificationType.CEDULA_DE_CIUDADANIA;
		}else if (op == 2) {
			typeOfId = IndentificationType.TARJETA_DE_IDENTIDAD;
		}else if (op == 3) {
			typeOfId = IndentificationType.CEDULA_DE_EXTRANJERIA;
		}else {
			typeOfId = IndentificationType.PASAPORTE;
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
