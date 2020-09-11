package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import model.TuDomicilio;

public class Menu {

	public static final int EXIT = 5;

	private Scanner sc;
	private static TuDomicilio tuDomi;

	public Menu() {

		sc = new Scanner(System.in);
		tuDomi = new TuDomicilio();
	}

	public void startMenu() {

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
		menu += "       BIENVENIDO A CLUB-RESTAURANT\n";
		menu += "   El lugar de tus restaurantes favoritos\n";
		menu += "================================================\n";
		menu += "";
		menu += "1. ";
		menu += "2. ";
		menu += "3. ";
		menu += "4. ";
		menu += "5. ";
		return menu;
	}

	private int readOption() {

		int op;
		op = Integer.parseInt(sc.nextLine());
		return op;
	}

	private void operation(int option) {

		switch (option) {
		case 1:

			break;

		case 2:

			break;

		case 3:

			break;

		case 4:

			break;

		case 5:

			break;

		}
	}

	private static void guardarDatos() throws IOException {

		File f = new File("archivos/datos.dat");
		if (f.exists() == false) {
			f.createNewFile();
		}

		ObjectOutputStream exportar = new ObjectOutputStream(new FileOutputStream(f));
		exportar.writeObject(tuDomi);
		exportar.close();

	}

	private static TuDomicilio cargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {

		TuDomicilio td = null;
		File f = new File("archivos/datos.dat");
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
