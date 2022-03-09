package com.perscholas.store;

public final class Constants {
	public static final String MYSQL_CJ_JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	public static final String JDBC_LOCALHOST_STORE = "jdbc:mariadb://localhost/store";

	public static final String USERNAME = "root";
	public static final String PASSWORD = "";

	public static final String CREATE_CUSTOMERS = "CREATE TABLE IF NOT EXISTS CUSTOMERS"
			+ "("
			+ " ID serial,"
			+ " EMAIL varchar(50),"
			+ " FNAME varchar(100),"
			+ " LNAME varchar(100),"
			+ " PRIMARY KEY (ID)"
			+ ")";

	public static final String CREATE_ITEMS = "CREATE TABLE IF NOT EXISTS ITEMS"
			+ "("
			+ " ID serial,"
			+ " NAME varchar(50),"
			+ " PRICE numeric,"
			+ " PRIMARY KEY (ID)"
			+ ")";
}
