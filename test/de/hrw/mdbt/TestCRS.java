package de.hrw.mdbt;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

public class TestCRS {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMain() {
		new CRS();
		CRS.main(new String[] {"db/test.yap"});
		
	}
	
	@Test(expected=Exception.class)
	public void testMainNull() {
		CRS.main(null);
		
	}

	@Test
	public void testSetUpDatabase() {
		EmbeddedConfiguration config = CRS.setUpConfiguration();
		ObjectContainer db = CRS.setUpDatabase(config, "db/test.yap");
		assertNotNull(db);
		db.close();
		
	}

	@Test
	public void testSetUpConfiguration() {
		EmbeddedConfiguration config = CRS.setUpConfiguration();
		assertNotNull(config);
		
	}

}
