package de.hrw.mdbt.model.employee;

import java.util.ArrayList;

import de.hrw.mdbt.model.Branch;
import de.hrw.mdbt.model.customer.Person;

public class Employee extends Person {
	private ArrayList<Task> tasks;
	private float salary;
	private String ssn;
	private Branch branch;
	private Employee supervisor;

}
