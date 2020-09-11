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
	
	public void addRestaurant() {
		
	}

}
