package com.perscholas.store;

public class Customer {

	private int id;
	private String email;
	private String fName;
	private String lName;

	public Customer(String email, String fName, String lName) {
		this.email = email;
		this.fName = fName;
		this.lName = lName;
	}

	public Customer(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
}
