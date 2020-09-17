package model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	
	private String code;
	private Date fecha_y_hora;
	private int customerCode;
	private StatusOrder status;
	// y una lista de productos ordenados...¿preguntar?
	

}
