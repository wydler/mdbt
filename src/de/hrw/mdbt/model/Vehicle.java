package de.hrw.mdbt.model;

import java.util.ArrayList;

import com.db4o.ObjectContainer;

import de.hrw.mdbt.model.Branch;

public class Vehicle {
	private String licenseNumber;
	private String insuranceNumber;
	private int actualKm;
	private Branch branch;
	private VehicleGroup vehicleGroup;
	private ArrayList<Report> reports;
	
	public Vehicle(String licenseNumber, String insuranceNumber, int actualKm, Branch branch, VehicleGroup vehicleGroup) {
		setLicenseNumber(licenseNumber);
		setInsuranceNumber(insuranceNumber);
		setActualKm(actualKm);
		setBranch(branch);
		setVehicleGroup(vehicleGroup);
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	public int getActualKm() {
		return actualKm;
	}
	public void setActualKm(int actualKm) {
		this.actualKm = actualKm;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		if (this.branch != null)
			this.branch.removeVehicle(this);
		this.branch = branch;
		if (branch != null)
			branch.addVehicle(this);
	}
	public VehicleGroup getVehicleGroup() {
		return vehicleGroup;
	}

	public void setVehicleGroup(VehicleGroup vehicleGroup) {
		this.vehicleGroup = vehicleGroup;
	}

	public ArrayList<Report> getReports() {
		return reports;
	}
	public void setReports(ArrayList<Report> reports) {
		this.reports = reports;
	}

	private boolean checkConstraints()
	{
		if (this.licenseNumber == null)
			return false;
		if (this.insuranceNumber == null) 
			return false;
		if (this.branch == null)
			return false;
		if (this.vehicleGroup == null)
			return false;
		if (this.actualKm < 0)
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
		if (branch != null) {
			db.activate(branch, 2);
			branch.removeVehicle(this);
			db.store(branch);
		}
		if (vehicleGroup != null) {
			db.activate(vehicleGroup, 1);
			vehicleGroup.removeVehicle(this);
			db.store(vehicleGroup);
		}
	}

	public String toString() {
		return
				"--------Vehicle--------\n" +
				"License: " + licenseNumber + "\n" +
				"Insurance: " + insuranceNumber + "\n" +
				"-----------------------\n";
	}
}