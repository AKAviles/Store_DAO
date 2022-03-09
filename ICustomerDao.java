package com.perscholas.store;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDao {
	enum SQL {
		GET_ALL_CUSTOMERS("SELECT * FROM customers"),
		GET_CUSTOMER_BY_ID("SELECT * FROM customers WHERE id=?"),
		DELETE_CUSTOMER_BY_ID("DELETE FROM customers WHERE id=?"),
		ADD_CUSTOMER("INSERT INTO customers(email, fName, lName) "
					+ "VALUES(?,?,?)");
		private final String query;

		private SQL(String s) {
			this.query = s;
		}

		public String getQuery() {
			return query;
		}
	}

	List<Customer> getAllCustomers();
	Customer getCustomerById(int id);
	Customer addCustomer(Customer c);
	boolean removeCustomerById(int id) throws SQLException;
}
