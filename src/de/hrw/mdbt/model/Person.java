package de.hrw.mdbt.model;

import java.util.ArrayList;


public class Person extends Customer {
	private String name;
	private int dob;
	private String email;
	private ArrayList<Phone> numbers = new ArrayList<Phone>();
	private ArrayList<Address> addresses = new ArrayList<Address>();
	private ArrayList<LicenseClass> licenses = new ArrayList<LicenseClass>();

	public Person(int id, String name) {
		super(id);
		setName(name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
