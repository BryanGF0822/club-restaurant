package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exception.TwoResWithSameNitR;

class TuDomicilioTest {

	private TuDomicilio tuDomi;
	
	public void setupStage1() {
		
		 tuDomi = new TuDomicilio();
	}
	
	public void setupStage2() throws TwoResWithSameNitR {
		
		tuDomi = new TuDomicilio();
		
		tuDomi.addRestaurant("El_Deleite_de_JuanCa", "A0035", "Bryan");
		tuDomi.addRestaurant("El_Parche", "A0012", "Manuel");
		tuDomi.addRestaurant("Empanadas_Cali", "A0044", "Andres");
	}
	
	public void setupStage3() {
		
		tuDomi = new TuDomicilio();
		
		tuDomi.addProduct("B0089", "Monster", "Energy_Drink", 8.300, "A0012");
		tuDomi.addProduct("B0023", "Nutella", "Chocolate_Cream", 12.54, "A0012");
	}
	
	public void setupStage4() {
		
		tuDomi = new TuDomicilio();
		
		tuDomi.addCustomer(IdentificationType.CEDULA_DE_CIUDADANIA, "1151", "Bryan", "Guapacha", "3015079361", "Calle70#25-75");
		tuDomi.addCustomer(IdentificationType.TARJETA_DE_IDENTIDAD, "67010", "Alexandra", "Florez", "3005071939", "Dig70g#30-26");
		tuDomi.addCustomer(IdentificationType.PASAPORTE, "12919", "Jader", "Loaiza", "3145663456", "Cra26h#66-77");
	}
	
	@Test
	public void addRestaurantTest() throws TwoResWithSameNitR {
		setupStage1();
		tuDomi.addRestaurant("Cosechas", "A0056", "Juan");
		assertEquals("Cosechas", tuDomi.getRestaurants().get(0).getName());
		assertEquals("A0056", tuDomi.getRestaurants().get(0).getNit());
		assertEquals("Juan", tuDomi.getRestaurants().get(0).getAdminName());

		setupStage2();
		tuDomi.addRestaurant("Cosechas", "A0056", "Juan");
		assertEquals("Cosechas", tuDomi.getRestaurants().get(3).getName());
		assertEquals("A0056", tuDomi.getRestaurants().get(3).getNit());
		assertEquals("Juan", tuDomi.getRestaurants().get(3).getAdminName());
	}
	
	@Test
	public void addProductTest() throws TwoResWithSameNitR {
		setupStage2();
		tuDomi.addProduct("B0089", "Monster", "Energy_Drink", 8.300, "A0012");
		assertEquals("B0089", tuDomi.getRestaurants().get(1).getProducts().get(0).getCode());
		assertEquals("Monster", tuDomi.getRestaurants().get(1).getProducts().get(0).getName());
		assertEquals("Energy_Drink", tuDomi.getRestaurants().get(1).getProducts().get(0).getDescription());
		assertEquals(8.300, tuDomi.getRestaurants().get(1).getProducts().get(0).getPrice());
		assertEquals("A0012", tuDomi.getRestaurants().get(1).getProducts().get(0).getNitRestaurant());

	}
	
	@Test
	public void addCustomerTest() {
		setupStage1();
		tuDomi.addCustomer(IdentificationType.CEDULA_DE_CIUDADANIA, "1151", "Bryan", "Guapacha", "3015079361", "Calle70#25-75");
		assertEquals(IdentificationType.CEDULA_DE_CIUDADANIA, tuDomi.getCustomers().get(0).getTypeOfId());
		assertEquals("1151", tuDomi.getCustomers().get(0).getIdNumber());
		assertEquals("Bryan", tuDomi.getCustomers().get(0).getName());
		assertEquals("Guapacha", tuDomi.getCustomers().get(0).getLastName());
		assertEquals("3015079361", tuDomi.getCustomers().get(0).getPhoneNumber());
		assertEquals("Calle70#25-75", tuDomi.getCustomers().get(0).getAddress());
	
		setupStage4();
		tuDomi.addCustomer(IdentificationType.CEDULA_DE_EXTRANJERIA, "11944", "Ana", "Cardona", "3163896657", "Av3N#34-56");
		assertEquals(IdentificationType.CEDULA_DE_EXTRANJERIA, tuDomi.getCustomers().get(3).getTypeOfId());
		assertEquals("11944", tuDomi.getCustomers().get(3).getIdNumber());
		assertEquals("Ana", tuDomi.getCustomers().get(3).getName());
		assertEquals("Cardona", tuDomi.getCustomers().get(3).getLastName());
		assertEquals("3163896657", tuDomi.getCustomers().get(3).getPhoneNumber());
		assertEquals("Av3N#34-56", tuDomi.getCustomers().get(3).getAddress());
	}

}
