package model;

import java.util.Comparator;
/**
 * 
 */
public class AlphabeticallyAscendingRestaurantComparator implements Comparator<Restaurant> {
	
	@Override
	public int compare(Restaurant o1, Restaurant o2) {
		int pos = 0;
		if (o1.getName().compareTo(o2.getName()) > 0) {
			pos = 1;
		}else if (o1.getName().compareTo(o2.getName()) < 0) {
			pos = -1;
		}else {
			pos = 0;
		}
		return pos;
	}
}
