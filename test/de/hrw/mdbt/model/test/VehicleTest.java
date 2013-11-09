package de.hrw.mdbt.model.test;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import de.hrw.mdbt.model.Address;
import de.hrw.mdbt.model.Branch;
import de.hrw.mdbt.model.Vehicle;
import de.hrw.mdbt.model.VehicleGroup;

public class VehicleTest {

	private static final String DB_TESTFILE = "VehicleTest.db4o";

	private static ObjectContainer db;

	private Branch b;
	private Vehicle v;
	private VehicleGroup vg;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Files.deleteIfExists(Paths.get(DB_TESTFILE));
		db = Db4oEmbedded.openFile(DB_TESTFILE);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		db.close();
	}

	@Before
	public void setUp() throws Exception {
		b = new Branch("myBranch",new Address(), Time.valueOf("9:0:0"), Time.valueOf("17:0:0"),"0123456789");
		vg = new VehicleGroup();
		v = new Vehicle("RV-DB-40","42",1,b,vg);
	}

	@After
	public void tearDown() throws Exception {
		db.rollback();
	}

	//TODO: add tests for getters/setters

	@Test
	public void testStore() {
		assertEquals(0,db.query(Vehicle.class).size());
		db.store(v);
		assertEquals(1,db.query(Vehicle.class).size());
	}

	@Test
	public void testStoreMultipleVehicles() {
		assertEquals(0,db.query(Branch.class).size());
		assertEquals(0,db.query(Vehicle.class).size());
		new Vehicle("RV-TT-0001","1",1,b,vg);
		new Vehicle("RV-TT-0002","2",10,b,vg);
		new Vehicle("RV-TT-0003","3",100,b,vg);
		new Vehicle("RV-TT-0004","4",1000,b,vg);
		db.store(b);
		assertEquals(1,db.query(Branch.class).size());
		assertEquals(5,db.query(Vehicle.class).size());
	}

	@Test
	public void testDelete() {
		assertEquals(0,db.query(Vehicle.class).size());
		db.store(v);
		assertEquals(1,db.query(Vehicle.class).size());
		db.delete(v);
		assertEquals(0,db.query(Vehicle.class).size());
	}

}
