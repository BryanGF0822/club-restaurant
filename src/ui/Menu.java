package ui;

import java.util.Scanner;

import model.TuDomicilio;

public class Menu {
	
	public static final int EXIT = 5;

	private Scanner sc;
	private TuDomicilio tuDomi;

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
		}while(option != EXIT);
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
}
