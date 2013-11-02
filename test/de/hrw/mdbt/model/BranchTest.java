package de.hrw.mdbt.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hrw.mdbt.model.customer.Address;
import de.hrw.mdbt.model.vehicle.Vehicle;

public class BranchTest {
	private static final String INITIAL_NAME = "myName";
	private static final String INITIAL_OPENINGHOURS = "9am to 5pm";
	private static final String INITIAL_PHONE = "0123456789";

	private Branch b;
	private Address a;
	private ArrayList<Vehicle> vs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		b = new Branch();

		a = new Address();
		vs = new ArrayList<Vehicle>();

		b.setAddress(a);
		b.setName("myName");
		b.setOpeningHours("9am to 5pm");
		b.setPhone("0123456789");
		b.setVehicles(vs);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertEquals(INITIAL_NAME, b.getName());
	}

	@Test
	public void testSetName() {
		b.setName("someOtherName");
		assertEquals("someOtherName", b.getName());
		b.setName(INITIAL_NAME);
		assertEquals(INITIAL_NAME, b.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals(a, b.getAddress());
	}

	@Test
	public void testSetAddress() {
		Address a2 = new Address();
		b.setAddress(a2);
		assertEquals(a2, b.getAddress());
		b.setAddress(a);
		assertEquals(a, b.getAddress());
	}

	@Test
	public void testGetOpeningHours() {
		assertEquals(INITIAL_OPENINGHOURS, b.getOpeningHours());
	}

	@Test
	public void testSetOpeningHours() {
		b.setOpeningHours("closed");
		assertEquals("closed", b.getOpeningHours());
		b.setOpeningHours(INITIAL_OPENINGHOURS);
		assertEquals(INITIAL_OPENINGHOURS, b.getOpeningHours());
	}

	@Test
	public void testGetPhone() {
		assertEquals(INITIAL_PHONE, b.getPhone());
	}

	@Test
	public void testSetPhone() {
		b.setPhone("1234567890");
		assertEquals("1234567890", b.getPhone());
		b.setPhone(INITIAL_PHONE);
		assertEquals(INITIAL_PHONE, b.getPhone());
	}

	@Test
	public void testGetVehicles() {
		assertEquals(vs, b.getVehicles());
	}

	@Test
	public void testSetVehicles() {
		ArrayList<Vehicle> vs2 = new ArrayList<Vehicle>();
		b.setVehicles(vs2);
		assertEquals(vs2, b.getVehicles());
		b.setVehicles(vs);
		assertEquals(vs, b.getVehicles());
	}

}
