package de.hrw.mdbt.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.db4o.ObjectSet;

import de.hrw.mdbt.CRSOperations;
import de.hrw.mdbt.model.Branch;
import de.hrw.mdbt.model.PriceClass;
import de.hrw.mdbt.model.VehicleGroup;

public class CRSOperationsTest {
	private static final String DB_TESTFILE = "CRSOperationsTest.db4o";

	private CRSOperations ops;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Files.deleteIfExists(Paths.get(DB_TESTFILE));
		ops = new CRSOperations(DB_TESTFILE);
		ops.fillDBDefaults();
	}

	@After
	public void tearDown() throws Exception {
		ops.getDb().close();
	}

	@Test
	public void testDefaultDBNotEmpty() {
		assertTrue(ops.getDb().query(Branch.class).size() > 0);
	}

	@Test
	public void testCreateOfferReturnsMultipleVehicleGroups() {
		Branch bExample = new Branch();
		bExample.setName("DefaultBranch");
		ObjectSet<Branch> bs = ops.getDb().queryByExample(bExample);
		assertEquals(1,bs.size());
		Branch b = bs.get(0);

		PriceClass pcExample = new PriceClass();
		pcExample.setName("TooCheapToDrive");
		ObjectSet<PriceClass> pcs = ops.getDb().queryByExample(pcExample);
		assertEquals(1,pcs.size());
		PriceClass pc = pcs.get(0);

		Calendar start = new GregorianCalendar(2013, 12, 1);
		Calendar end = new GregorianCalendar(2014, 1, 1);

		ObjectSet<VehicleGroup> vgs = ops.createOffer(b, start.getTime(), end.getTime(), pc);

		assertEquals(3,vgs.size());
	}

	@Test
	public void testCreateOfferDateRangesAreExclusive() {
		Branch bExample = new Branch();
		bExample.setName("DefaultBranch");
		ObjectSet<Branch> bs = ops.getDb().queryByExample(bExample);
		assertEquals(1,bs.size());
		Branch b = bs.get(0);

		PriceClass pcExample = new PriceClass();
		pcExample.setName("TooCheapToDrive");
		ObjectSet<PriceClass> pcs = ops.getDb().queryByExample(pcExample);
		assertEquals(1,pcs.size());
		PriceClass pc = pcs.get(0);

		Calendar start = new GregorianCalendar(2012, 6, 2);
		Calendar end = new GregorianCalendar(2012, 12, 31);
		ObjectSet<VehicleGroup> vgs = ops.createOffer(b, start.getTime(), end.getTime(), pc);
		assertEquals(3,vgs.size());

		start = new GregorianCalendar(2012, 6, 1);
		end = new GregorianCalendar(2012, 12, 31);
		vgs = ops.createOffer(b, start.getTime(), end.getTime(), pc);
		assertEquals(2,vgs.size());

		start = new GregorianCalendar(2012, 6, 2);
		end = new GregorianCalendar(2013, 1, 1);
		vgs = ops.createOffer(b, start.getTime(), end.getTime(), pc);
		assertEquals(2,vgs.size());
	}

	@Test
	public void testCreateOfferNoDateMatch() {
		Branch bExample = new Branch();
		bExample.setName("AnotherDefaultBranch");
		ObjectSet<Branch> bs = ops.getDb().queryByExample(bExample);
		assertEquals(1,bs.size());
		Branch b = bs.get(0);

		PriceClass pcExample = new PriceClass();
		pcExample.setName("IAmBatMan");
		ObjectSet<PriceClass> pcs = ops.getDb().queryByExample(pcExample);
		assertEquals(1,pcs.size());
		PriceClass pc = pcs.get(0);

		Calendar start = new GregorianCalendar(2011, 1, 1);
		Calendar end = new GregorianCalendar(2014, 1, 1);

		ObjectSet<VehicleGroup> vgs = ops.createOffer(b, start.getTime(), end.getTime(), pc);

		assertEquals(0,vgs.size());
	}
}
