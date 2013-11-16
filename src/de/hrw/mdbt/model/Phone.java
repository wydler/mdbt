package de.hrw.mdbt.model;

public class Phone {
	private String type;
	private String prefix;
	private String number;

	public Phone(String prefix, String number, String type) {
		this.prefix = prefix;
		this.number = number;
		this.type = type;
	}
	
}
