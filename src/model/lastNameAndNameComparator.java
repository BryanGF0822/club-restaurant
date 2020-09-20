package model;

import java.util.Comparator;

public class lastNameAndNameComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		
		int comp = 0;
		if (o1.getLastName().compareTo(o2.getLastName())<0) {
			comp = 1;
		}else if (o1.getLastName().compareTo(o2.getLastName())>0) {
			comp = -1;
		}else {
			
			if (o1.getName().compareTo(o2.getName())<0) {
				comp = 1;
			}else if (o1.getName().compareTo(o2.getName())>0) {
				comp = -1;
			}else {
				comp = 0;
			}
		}
		return comp;
	}

}
