package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
/**
 * 
 */
public class Restaurant implements Serializable {
	
	private String name;
	private String nit;
	private String adminName;
	
	private List<Product> products;

	/**
	 * [Restaurant description]
	 * @param  name      [description]
	 * @param  nit       [description]
	 * @param  adminName [description]
	 * @return           [description]
	 */
	public Restaurant(String name, String nit, String adminName) {
		this.name = name;
		this.nit = nit;
		this.adminName = adminName;
		
		products = new ArrayList<Product>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public List<Product> getProducts() {
		return products;
	}

	/**
	 * [addProduct description]
	 * @param co      [description]
	 * @param na      [description]
	 * @param descrip [description]
	 * @param pri     [description]
	 * @param nitR    [description]
	 */
	public void addProduct(String co, String na, String descrip, double pri, String nitR) {
		
		Product newprod = new Product(co, na, descrip, pri, nitR);
		products.add(newprod);
	}

	/**
	 * [updateProductConfirmation description]
	 * @param  co [description]
	 * @return    [description]
	 */
	public boolean updateProductConfirmation(String co) {
		
		boolean found = false;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCode().compareTo(co) == 0) {
				found = true;
			}
		}
		return found;
	}
	
	public void importDataProduct(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(" ");			
			Product prod = new Product(split[0], split[1], split[2], Double.parseDouble(split[3]), split[4]);
			products.add(prod);
			line = br.readLine();
			
		}
	}
	
	/**
	 * [toString description]
	 * @return [description]
	 */
	@Override
	public String toString() {
		return "Restaurant name: " + name + ", Nit: " + nit + ", AdminName:" + adminName + "\n";
	}

}
