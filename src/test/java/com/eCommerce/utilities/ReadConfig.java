package com.eCommerce.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	// Declare the Properties object
	private Properties pro;

	// Constructor to load the configuration file
	public ReadConfig() {
		// Specify the correct path to the properties file
		String filePath = "./Configuration/config.properties";

		try {
			// Create a FileInputStream to read the properties file
			FileInputStream fis = new FileInputStream(filePath);
			pro = new Properties();
			pro.load(fis); // Load the properties from the file
		} catch (IOException e) {
			// Print an error message if there's an issue reading the file
			System.out.println("Exception occurred while reading the properties file: " + e.getMessage());
		}
	}

	// Method to get the Application URL
	public String getApplicationUrl() {
		return pro.getProperty("baseUrl"); // Retrieve the value of baseUrl from the properties file
	}

	// Method to get the Username
	public String getUserName() {
		return pro.getProperty("username"); // Retrieve the value of username from the properties file
	}

	// Method to get the Password
	public String getPassword() {
		return pro.getProperty("password"); // Retrieve the value of password from the properties file
	}
}
