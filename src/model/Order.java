package model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	
	private String code;
	private Date fecha_y_hora;
	private String customerCode;
	private StatusOrder status;
	
	public Order(String code, Date fecha_y_hora, String customerCode, StatusOrder status) {
		this.code = code;
		this.fecha_y_hora = fecha_y_hora;
		this.customerCode = customerCode;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getFecha_y_hora() {
		return fecha_y_hora;
	}

	public void setFecha_y_hora(Date fecha_y_hora) {
		this.fecha_y_hora = fecha_y_hora;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public StatusOrder getStatus() {
		return status;
	}

	public void setStatus(StatusOrder status) {
		this.status = status;
	}
	
	
}
