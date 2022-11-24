package com.kvcet.socialapp.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection connection;

	private ConnectionUtil() {

	}

	public static Connection getConnection() throws IOException, SQLException {
		Properties properties = new Properties();
		FileReader file = new FileReader(
				"C:\\Users\\ELCOT\\eclipse-workspace\\social-app\\src\\main\\resources\\application.properties");
		properties.load(file);
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = "";
		if (connection == null) {
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;

	}

}
