package de.hrw.mdbt.model;

import java.sql.Time;
import java.util.ArrayList;

import com.db4o.ObjectContainer;

import de.hrw.mdbt.model.Address;
import de.hrw.mdbt.model.Vehicle;

public class Branch {
	private boolean aboutToDelete = false;

	private String name;
	private Address address;
	private Time openingTime;
	private Time closingTime;
	private String phone;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	public Branch(String name, Address address, Time openingTime, Time closingTime, String phone)
	{
		setName(name);
		setAddress(address);
		setOpeningTime(openingTime);
		setClosingTime(closingTime);
		setPhone(phone);
	}

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
	public Time getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(Time opening) {
		this.openingTime = opening;
	}
	public Time getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(Time closing) {
		this.closingTime = closing;
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

	protected void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
		//TODO: remove link from Vehicles
	}
	protected void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	
	protected void removeVehicle(Vehicle vehicle) {
		this.vehicles.remove(vehicle);
	}

	private boolean checkConstraints()
	{
		//HACK: prevent inserts/updates during objectOnDelete
		if (aboutToDelete)
			return false;

		if (this.name == null)
			return false;
		if (this.phone == null) 
			return false;
		if (this.address == null)
			return false;
		if (this.openingTime == null)
			return false;
		if (this.closingTime == null)
			return false;
		return true;
	}

	public boolean objectCanNew(ObjectContainer db) {
		return checkConstraints();
	}

	public boolean objectCanUpdate(ObjectContainer db) {
		return checkConstraints();
	}

	public void objectOnDelete(ObjectContainer db) {
		aboutToDelete = true;
		//HACK: need clone - vehicle could call removeVehicle and modify this list while iterating over it in this method
		@SuppressWarnings("unchecked")
		ArrayList<Vehicle> vehiclesToDelete = (ArrayList<Vehicle>) vehicles.clone();
		for (Vehicle v : vehiclesToDelete) {
			if (v != null)
			{
				db.activate(v, 1);
				db.delete(v);
			}
		}
	}

	public String toString() {
		return
				"--------Branch--------\n" +
				name + "\n" +
				address + "\n" +
				"From " + openingTime.toString() + " to " + closingTime.toString() + "\n" +
				"Phone: " + phone +
				"----------------------\n";
	}
}
