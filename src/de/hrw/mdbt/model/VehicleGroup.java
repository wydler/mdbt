package de.hrw.mdbt.model;

import java.util.Date;
import java.util.ArrayList;

import de.hrw.mdbt.model.Model;

public class VehicleGroup {
	private int power;
	private String fuelType;
	private Date purchaseDate;
	private String color;
	private Model model;
	private PriceClass priceClass;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private ArrayList<Equipment> equipment = new ArrayList<Equipment>();

	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public PriceClass getPriceClass() {
		return priceClass;
	}
	public void setPriceClass(PriceClass priceClass) {
		this.priceClass = priceClass;
	}
	public ArrayList<Equipment> getEquipment() {
		return equipment;
	}
	public void setEquipment(ArrayList<Equipment> equipments) {
		this.equipment = equipments;
	}
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	protected void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	protected void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	protected void removeVehicle(Vehicle vehicle) {
		this.vehicles.remove(vehicle);
	}
}
