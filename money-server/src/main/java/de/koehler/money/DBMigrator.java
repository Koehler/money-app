package de.koehler.money;

import com.googlecode.flyway.core.Flyway;

/**
 * 
 * @author Matthias Köhler
 */
public class DBMigrator {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/money";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public static void main(String[] args) {
		Flyway flyway = new Flyway();
		flyway.setDataSource(DB_URL, DB_USER, DB_PASSWORD);
		flyway.migrate();
	}

}
