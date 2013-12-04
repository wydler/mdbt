package de.hrw.mdbt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

import de.hrw.mdbt.model.Address;
import de.hrw.mdbt.model.Branch;
import de.hrw.mdbt.model.LicenseClass;
import de.hrw.mdbt.model.Model;
import de.hrw.mdbt.model.Person;
import de.hrw.mdbt.model.PriceClass;
import de.hrw.mdbt.model.Rental;
import de.hrw.mdbt.model.Vehicle;
import de.hrw.mdbt.model.VehicleGroup;


public class CRS {
	
	private static final String DB_TESTFILE = "Test.db4o";
	
	private static ObjectContainer db;

	public static void main(String[] args) {
		CRSOperations ops = new CRSOperations(DB_TESTFILE);
		ops.fillDBDefaults();
		db = ops.getDb();
		
		Scanner input = new Scanner(System.in);
		String s = "";
		
		while(s != "q") {
			db.ext().setSemaphore("reservation", 1000);
			
			System.out.println("Branch auswählen:");
			List<Branch> branches = db.query(Branch.class);
			for(int i=0; i<branches.size(); i++) {
				System.out.println(i+" - "+branches.get(i).getName());
			}
			Branch branch = branches.get(input.nextInt());
			
			System.out.println("\nKunde auswählen:");
			List<Person> customers = db.query(Person.class);
			for(int i=0; i<customers.size(); i++) {
				System.out.println(i+" - "+customers.get(i).getLastname());
			}
			Person customer = customers.get(input.nextInt());
			
			System.out.println("\nPreisklasse auswählen:");
			List<PriceClass> priceClasses = db.query(PriceClass.class);
			for(int i=0; i<priceClasses.size(); i++) {
				System.out.println(i+" - "+priceClasses.get(i).getName());
			}
			PriceClass priceClass = priceClasses.get(input.nextInt());
			
			SimpleDateFormat sdfToDate = new SimpleDateFormat("dd.MM.yyyy");
			Date start = null;
			Date end = null;
		    try {
		    	System.out.println("\nStartdatum eingeben:");
				start = sdfToDate.parse(input.next());
				System.out.println("\nEnddatum eingeben:");
				end = sdfToDate.parse(input.next());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			System.out.println("\nFahrzeuggruppe auswählen:");
			List<VehicleGroup> vehicleGroups = CRSOperations.createOffer(db, branch, start, end, priceClass);
			for(int i=0; i<vehicleGroups.size(); i++) {
				System.out.println(i+" - "+vehicleGroups.get(i).getPower()+" PS");
			}
			VehicleGroup vehicleGroup = vehicleGroups.get(input.nextInt());
			
			CRSOperations.createReservation(db, customer, branch, vehicleGroup, start, end);
			
			db.ext().releaseSemaphore("reservation");
			
			s = input.next();
		}
		
		input.close();
		db.close();
	}
	
	public static EmbeddedConfiguration setUpConfiguration() {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		return config;
	}
	
	public static ObjectContainer setUpDatabase(EmbeddedConfiguration config, String filename) {
		ObjectContainer db = Db4oEmbedded.openFile(config, filename);
		return db;
	}

}
