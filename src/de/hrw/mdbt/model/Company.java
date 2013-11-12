package de.hrw.mdbt.model;

import java.util.ArrayList;

public class Company extends Customer {
	private String name;
	private ArrayList<Person> representatives = new ArrayList<Person>();

	public Company(int id, String name) {
		super(id);
		setName(name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
