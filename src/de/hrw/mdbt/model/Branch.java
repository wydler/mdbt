package de.hrw.mdbt.model;

import java.util.ArrayList;

import de.hrw.mdbt.model.customer.Address;
import de.hrw.mdbt.model.vehicle.Vehicle;

public class Branch {
	private String name;
	private Address address;
	private String openingHours;
	private String phone;
	private ArrayList<Vehicle> vehicles;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
