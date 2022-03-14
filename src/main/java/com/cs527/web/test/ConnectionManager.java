package com.cs527.web.test;

//import org.junit.Test;

import java.sql.*;
import java.util.Properties;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2022-03-13 21:17
 * @description:
 */
public class ConnectionManager {

	private static final String JDBC_URL =
			"jdbc:redshift://redshift-cluster-1.ct9e2j27bris.us-east-1.redshift.amazonaws.com:5439/cs527";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "Rutgerscs527";
	private static final String CLASS_NAME = "com.amazon.redshift.jdbc42.Driver";

	private Connection connection = null;

//	@Test
	public void connect() {
		// Dynamically load driver at runtime.
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver class could not loaded");
			System.out.println(e.getMessage());
		}
		Properties properties = getPropertiesForDriverManager();
		try {
			System.out.println("Connecting to the database...");
			connection = DriverManager.getConnection(JDBC_URL, properties);
			PreparedStatement preparedStatement = connection.prepareStatement("select  * from aisles");
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("success");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private Properties getPropertiesForDriverManager() {
		Properties props = new Properties();
		props.setProperty("user", USERNAME);
		props.setProperty("password", PASSWORD);
		return props;
	}
}