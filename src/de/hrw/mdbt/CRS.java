package de.hrw.mdbt;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.constraints.UniqueFieldValueConstraint;
import com.db4o.constraints.UniqueFieldValueConstraintViolationException;

import de.hrw.mdbt.model.Car;

public class CRS {
	
	private static ObjectContainer db;
	private static EmbeddedConfiguration config;

	public static void main(String[] args) {
		config = setUpConfiguration();
		db = setUpDatabase(config, args[0]);
		System.out.println(db.query(Car.class));
		db.close();
		
	}
	
	public static EmbeddedConfiguration setUpConfiguration() {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().objectClass(Car.class).objectField("registration").indexed(true);
		config.common().add(new UniqueFieldValueConstraint(Car.class, "registration"));
		
		return config;
		
	}
	
	public static ObjectContainer setUpDatabase(EmbeddedConfiguration config, String filename) {
		return Db4oEmbedded.openFile(config, filename);
		
	}

}