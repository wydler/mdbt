package de.hrw.mdbt.model;

import java.util.ArrayList;

public class PriceClass {
	private String name;
	private String description;
	private float freeKm;
	private float priceKm;
	private float priceDay;
//	private ArrayList <Model> models;

	public PriceClass(String name, String description, int freeKm, int priceDay, int priceKm) {
		this.setName(name);
		this.setDescription(description);
		this.setFreeKm(freeKm);
		this.setPriceDay(priceDay);
		this.setPriceKm(priceKm);
//		this.setModels(new ArrayList<Model>());
	}

	public PriceClass() {
		this.setFreeKm(0); // set default values
		this.setPriceDay(0);
		this.setPriceKm(0);
//		this.setModels(new ArrayList<Model>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getFreeKm() {
		return freeKm;
	}

	public void setFreeKm(float freeKm) {
		this.freeKm = freeKm;
	}

	public float getPriceKm() {
		return priceKm;
	}

	public void setPriceKm(float priceKm) {
		this.priceKm = priceKm;
	}

	public float getPriceDay() {
		return priceDay;
	}

	public void setPriceDay(float priceDay) {
		this.priceDay = priceDay;
	}
/*
	public ArrayList<Model> getModels() {
		return models;
	}

	public void setModels(ArrayList<Model> models) {
		this.models = models;
	}
*/
}
