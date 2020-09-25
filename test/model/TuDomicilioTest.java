package model;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.plaf.TableUI;

import org.junit.jupiter.api.Test;

class TuDomicilioTest {

	private TuDomicilio tuDomi;
	
	public void setupStage1() {
		
		 tuDomi = new TuDomicilio();
	}
	
	public void setupStage2() {
		
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
	
	@Test
	public void addRestaurantTest() {
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
	public void addProductTest() {
		setupStage2();
		tuDomi.addProduct("B0089", "Monster", "Energy_Drink", 8.300, "A0012");
		assertEquals("B0089", tuDomi.getRestaurants().get(1).getProducts().get(0).getCode());
		assertEquals("Monster", tuDomi.getRestaurants().get(1).getProducts().get(0).getName());
		assertEquals("Energy_Drink", tuDomi.getRestaurants().get(1).getProducts().get(0).getDescription());
		assertEquals(8.300, tuDomi.getRestaurants().get(1).getProducts().get(0).getPrice());
		assertEquals("A0012", tuDomi.getRestaurants().get(1).getProducts().get(0).getNitRestaurant());

	}

}
