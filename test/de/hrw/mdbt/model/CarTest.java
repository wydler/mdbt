/**
 * 
 */
package de.hrw.mdbt.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author michael
 *
 */
public class CarTest {
	
	private Car car;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		car = new Car("BC-AB 1234");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		car = null;
		
	}

	/**
	 * Test method for {@link de.hrw.mdbt.model.Car#Car(java.lang.String)}.
	 */
	@Test
	public void testCar() {
		assertNotNull(car);
		
	}

	/**
	 * Test method for {@link de.hrw.mdbt.model.Car#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("BC-AB 1234", car.toString());
		
	}
	
	/**
	 * Test method for {@link de.hrw.mdbt.model.Car#objectCanNew()}.
	 */
	@Test
	public void testObjectCanNew() {
		assertTrue(car.objectCanNew(null));
		
	}
	
	/**
	 * Test method for {@link de.hrw.mdbt.model.Car#objectCanNew()}.
	 */
	@Test
	public void testObjectCanNewInvalid() {
		car = new Car(null);
		assertFalse(car.objectCanNew(null));
		
	}

}
