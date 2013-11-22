package de.hrw.mdbt;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.CommonConfigurationProvider;
import com.db4o.config.EmbeddedConfiguration;

import de.hrw.mdbt.model.Address;
import de.hrw.mdbt.model.Branch;
import de.hrw.mdbt.model.Company;
import de.hrw.mdbt.model.Customer;
import de.hrw.mdbt.model.Model;
import de.hrw.mdbt.model.Person;
import de.hrw.mdbt.model.PriceClass;
import de.hrw.mdbt.model.Vehicle;
import de.hrw.mdbt.model.VehicleGroup;

public class CRSOperations {
	ObjectContainer db;
	CommonConfigurationProvider config;

	public ObjectContainer getDb() {
		return db;
	}

	public CommonConfigurationProvider getConfig() {
		return config;
	}

	public CRSOperations(String file) {
		this.config = Db4oEmbedded.newConfiguration();
		this.db = Db4oEmbedded.openFile((EmbeddedConfiguration)config, file);
		configureAll(config);
	}

	public void fillDBDefaults() {
		fillDBDefaults(this.db);
	}

	public ObjectSet <VehicleGroup> createOffer(Branch b, Date startDate, Date endDate, PriceClass pc)	{
		return createOffer(this.db, b, startDate, endDate, pc);
	}

	public int createReservation (Customer c, Branch b, VehicleGroup vg, Date startDate, Date endDate) {
		return createReservation(this.db, c, b, vg, startDate, endDate);
	}

	public static void configureAll(CommonConfigurationProvider config) {
		if(config == null)
			return;
		Branch.configure(config);
		//TODO: Add all configure methods here OR switch to interface and callback structure and let all classes register themselves "somewhere"
	}

	public static void fillDBDefaults(ObjectContainer db) {
		Branch b1 = new Branch("DefaultBranch",
				new Address("DefaultState", "DefaultCity", "DefaultStreet", "123456", "DefaultType"),
				Time.valueOf("9:0:0"), Time.valueOf("17:0:0"),
				"0123456789");
		Calendar c1 = new GregorianCalendar(2013, 1, 1);
		Model m1 = new Model();
		PriceClass pc1 = new PriceClass("TooCheapToDrive", "Good Luck!", 10, 2, 3);
		VehicleGroup vg1 = new VehicleGroup(100, "Diesel", c1.getTime(), "Blue Metallic", m1, pc1);
		new Vehicle("RV-DE-0001","1",1,b1,vg1);
		new Vehicle("RV-FA-0002","2",10,b1,vg1);
		new Vehicle("RV-UL-0003","3",100,b1,vg1);
		new Vehicle("RV-T-0004","4",1000,b1,vg1);
		Calendar c2 = new GregorianCalendar(2012, 1, 1);
		Model m2 = new Model();
		PriceClass pc2 = new PriceClass("TooSlowToDrive", "Take Your Time!", 1, 10, 100);
		VehicleGroup vg2 = new VehicleGroup(10, "Benzin", c2.getTime(), "Blue Metallic", m2, pc2);
		new Vehicle("RV-DE-0005","1",1,b1,vg2);
		new Vehicle("RV-FA-0006","2",10,b1,vg2);
		new Vehicle("RV-UL-0007","3",100,b1,vg2);
		new Vehicle("RV-TY-0008","4",1000,b1,vg2);
		db.store(b1);

		Branch b2 = new Branch("AnotherDefaultBranch",
				new Address("DefaultState", "AnotherDefaultCity", "DefaultStreet", "234567", "DefaultType"),
				Time.valueOf("8:0:0"), Time.valueOf("16:0:0"),
				"0234567891");
		Calendar c3 = new GregorianCalendar(2013, 1, 2);
		Model m3 = new Model();
		PriceClass pc3 = new PriceClass("IAmBatMan", "NANANANANANANANANANANANANANANANANANA BATMAAAN!!!", 0, 999, 9999);
		VehicleGroup vg3 = new VehicleGroup(100, "Diesel", c3.getTime(), "Blue Metallic", m3, pc3);
		new Vehicle("FN-BM-0001","1",1,b2,vg3);
		new Vehicle("FN-RB-0002","2",10,b2,vg3);
		db.store(b2);
		
		Calendar c4 = new GregorianCalendar(2000, 1, 1);
		Person p1 = new Person(1, "Max", "", "Mad", "?", "", c4.getTime(), "m");
		db.store(p1);

		Company cy1 = new Company(2,"Knight Industries");
		db.store(cy1);

		db.commit();
	}

	public static ObjectSet <VehicleGroup> createOffer(ObjectContainer db, Branch b, Date startDate, Date endDate, PriceClass pc)	{
		return null;
		//TODO: implement
	}

	public static int createReservation(ObjectContainer db, Customer c, Branch b, VehicleGroup vg, Date startDate, Date endDate) {
		return 0;
		//TODO: implement
	}
}
