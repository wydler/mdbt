package de.hrw.mdbt.model;

import java.util.Date;
import java.util.GregorianCalendar;

public class Customer {
	private int id;
	private Date registerDate = GregorianCalendar.getInstance().getTime();
	private float discount = 0.0f;
	
	public Customer() {
	}

	public Customer(int id) {
		setId(id);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
}
