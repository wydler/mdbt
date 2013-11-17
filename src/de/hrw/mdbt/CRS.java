package de.hrw.mdbt;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;


public class CRS {
	
	private static ObjectContainer db;
	private static EmbeddedConfiguration config;

	public static void main(String[] args) {
		config = setUpConfiguration();
		db = setUpDatabase(config, args[0]);
		db.close();
	}
	
	public static EmbeddedConfiguration setUpConfiguration() {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		return config;
	}
	
	public static ObjectContainer setUpDatabase(EmbeddedConfiguration config, String filename) {
		return Db4oEmbedded.openFile(config, filename);
	}

}
