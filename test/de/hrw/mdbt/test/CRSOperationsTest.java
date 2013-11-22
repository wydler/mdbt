package de.hrw.mdbt.test;

import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hrw.mdbt.CRSOperations;
import de.hrw.mdbt.model.Branch;

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
}
