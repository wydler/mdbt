package de.hrw.mdbt.model;

import java.util.ArrayList;

import de.hrw.mdbt.model.Branch;
import de.hrw.mdbt.model.Person;

public class Employee extends Person {
	private ArrayList<Task> tasks;
	private float salary;
	private String ssn;
	private Branch branch;
	private Employee supervisor;

}
