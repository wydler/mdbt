package de.hrw.mdbt;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import de.hrw.mdbt.model.Car;

public class CRS {

	public static void main(String[] args) {
		System.out.println("Hallo Welt!");
		
		ObjectContainer db = Db4oEmbedded.openFile("db/dev.yap");
		
		try {
			db.store(new Car("BC-AB 1234"));
			db.commit();
			System.out.println(db.query(Car.class));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		
	}

}