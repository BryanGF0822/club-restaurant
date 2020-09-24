package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
/**
 * 
 */
public class Order implements Serializable{
	
	private String code;
	private Date fecha_y_hora;
	private String customerCode;
	private String nitResProSelected;
	private String quantity;
	private StatusOrder status;
	private String listPS;
	
	/**
	 * [Order description]
	 * @param  code              [description]
	 * @param  fecha_y_hora      [description]
	 * @param  customerCode      [description]
	 * @param  nitResProSelected [description]
	 * @param  quantity          [description]
	 * @param  status            [description]
	 * @param  listPS            [description]
	 * @return                   [description]
	 */
	public Order(String code, Date fecha_y_hora, String customerCode, String nitResProSelected, String quantity, StatusOrder status, String listPS) {
		this.code = code;
		this.fecha_y_hora = fecha_y_hora;
		this.customerCode = customerCode;
		this.nitResProSelected = nitResProSelected;
		this.quantity = quantity;
		this.status = status;
		this.listPS = listPS;
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

	public String getNitResProSelected() {
		return nitResProSelected;
	}

	public void setNitResProSelected(String nitResProSelected) {
		this.nitResProSelected = nitResProSelected;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public StatusOrder getStatus() {
		return status;
	}

	public void setStatus(StatusOrder status) {
		this.status = status;
	}

	public String getListPS() {
		return listPS;
	}

	public void setListPS(String listPS) {
		this.listPS = listPS;
	}
	
	
}
