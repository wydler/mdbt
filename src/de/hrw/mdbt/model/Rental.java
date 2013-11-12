package de.hrw.mdbt.model;

import java.util.Date;

public class Rental {
	private Date startDate;
	private Date endDate;
	private int startKm;
	private int endKm;
	private Vehicle vehicle;
	private String status;

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getStartKm() {
		return startKm;
	}
	public void setStartKm(int startKm) {
		this.startKm = startKm;
	}
	public int getEndKm() {
		return endKm;
	}
	public void setEndKm(int endKm) {
		this.endKm = endKm;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
