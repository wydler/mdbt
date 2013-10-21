package de.hrw.mdbt.model;

import com.db4o.ObjectContainer;

public class Car {

	private String registration;
	
	public Car(String registration) {
		this.registration = registration;
		
	}
	
	public String toString() {
		return this.registration;
		
	}
	
	public boolean objectCanNew(ObjectContainer dbConn) {
		if(this.registration == null) return false;
		
		return true;
		
	}
	
}
