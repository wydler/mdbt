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

}
