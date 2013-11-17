package de.hrw.mdbt.model;

public class Model {
	private String manufacturer;
	private String name;
	private VehicleGroup group;
	private int capacity;
	private String measure;

	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VehicleGroup getGroup() {
		return group;
	}
	public void setGroup(VehicleGroup group) {
		this.group = group;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
}
