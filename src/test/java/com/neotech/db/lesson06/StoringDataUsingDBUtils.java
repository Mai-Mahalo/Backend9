package com.neotech.db.lesson06;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.neotech.utils.DBUtils;

public class StoringDataUsingDBUtils extends DBUtils {

	@Test
	public void getDataFromDB() {
		// Ensure the connection is established
		getConnection();

		// Define the query to fetch employee data
		String query = "SELECT employeeNumber, lastName, firstName, email FROM employees LIMIT 5;";
		List<Map<String, String>> employeeList = storeDataFromDb(query);

		// Print the employee data
		System.out.println(employeeList);

		// Close the connection
		closeConnection();
	}

	@Test
	public void getDataFromDB2() {
		String query = "SELECT employeeNumber, lastName, firstName, email FROM employees LIMIT 5;";
		List<Map<String, String>> employeeList = storeDataFromDb2(query);

		// Print the employee data
		System.out.println(employeeList);
	}

	@Test
	public void getFirstTenCustomersFromDB() {
		String query = "select * from customers limit 10;";
		List<Map<String, String>> customerList = storeDataFromDb2(query);

		// Print the customer data
		System.out.println(customerList);

		for (Map<String, String> customer : customerList) {
			System.out.println("Customer Number: " + customer.get("customerNumber"));
			System.out.println("Customer Name: " + customer.get("customerName"));
			System.out.println("Contact Last Name: " + customer.get("contactLastName"));
			System.out.println("Contact First Name: " + customer.get("contactFirstName"));
			System.out.println("Phone: " + customer.get("phone"));
			System.out.println("-----------------------------");
		}
	}
}
