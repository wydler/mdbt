package de.hrw.mdbt.model.test;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import de.hrw.mdbt.model.Model;
import de.hrw.mdbt.model.PriceClass;
import de.hrw.mdbt.model.VehicleGroup;

public class VehicleGroupTest {

	private static final String DB_TESTFILE = "VehicleGroupTest.db4o";

	private static ObjectContainer db;

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
		Calendar c = new GregorianCalendar();
	    c.set(Calendar.DAY_OF_WEEK, 1);
	    c.set(Calendar.MONTH, 1);
	    c.set(Calendar.YEAR, 2013);
		vg = new VehicleGroup(142, "Nuklearer Abfall", c.getTime(), "Blau", new Model(), new PriceClass());
	}

	@After
	public void tearDown() throws Exception {
		db.rollback();
	}

	//TODO: add tests for getters/setters

	@Test
	public void testStore() {
		assertEquals(0,db.query(VehicleGroup.class).size());
		db.store(vg);
		assertEquals(1,db.query(VehicleGroup.class).size());
	}

	@Test
	public void testStoreMultipleVehicleGroups() {
		Calendar c1 = new GregorianCalendar();
	    c1.set(Calendar.DAY_OF_WEEK, 1);
	    c1.set(Calendar.MONTH, 1);
	    c1.set(Calendar.YEAR, 2013);
		Calendar c2 = new GregorianCalendar();
	    c2.set(Calendar.DAY_OF_WEEK, 2);
	    c2.set(Calendar.MONTH, 1);
	    c2.set(Calendar.YEAR, 2012);
		assertEquals(0,db.query(VehicleGroup.class).size());
		db.store(new VehicleGroup(142, "Nuklearer Abfall", c1.getTime(), "Blau Metallic", new Model(), new PriceClass()));
		db.store(new VehicleGroup(100, "Diesel", c2.getTime(), "Rot", new Model(), new PriceClass()));
		assertEquals(2,db.query(VehicleGroup.class).size());
	}

	@Test
	public void testDelete() {
		assertEquals(0,db.query(VehicleGroup.class).size());
		db.store(vg);
		assertEquals(1,db.query(VehicleGroup.class).size());
		db.delete(vg);
		assertEquals(0,db.query(VehicleGroup.class).size());
	}

}
