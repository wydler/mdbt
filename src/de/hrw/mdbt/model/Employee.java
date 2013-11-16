package de.hrw.mdbt.model;

import java.util.ArrayList;

import de.hrw.mdbt.model.Branch;
import de.hrw.mdbt.model.Person;

public class Employee extends Person {
	private ArrayList<Task> tasks = new ArrayList<Task>();
	private float salary;
	private String ssn;
	private Branch branch;
	private Employee supervisor;

	public Employee(int id, String lastname) {
		super(id, lastname);
	}

	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Employee getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
}
