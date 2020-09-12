package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TuDomicilio implements Serializable {
	
	private List<Restaurant> restaurants;
	
	public TuDomicilio() {
		
		restaurants = new ArrayList<Restaurant>();
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	
	public void addRestaurant(String na, String ni, String admin) {
		
		Restaurant newRest = new Restaurant(na, ni, admin);
		restaurants.add(newRest);
	}

}
