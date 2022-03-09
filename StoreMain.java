package com.perscholas.store;

import java.sql.SQLException;

public class StoreMain {
	public static void main(String[] args) throws SQLException {
		IItemDao itemDao = new ItemDao();
		ICustomerDao customerDao = new CustomerDao();
		Customer tim = new Customer("tim@", "tim", "boe");
		Customer jim = new Customer("abc@gmail", "jim", "joe");
		Customer ant = new Customer("asdf", "ant", "hony");
		customerDao.addCustomer(tim);



	}
}
