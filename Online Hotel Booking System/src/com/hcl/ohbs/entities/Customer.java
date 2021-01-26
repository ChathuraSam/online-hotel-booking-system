package com.hcl.ohbs.entities;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String email;
	private String username;
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customer(String firstName, String lastName, String phoneNumber, String address, String email,
			String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
	public Customer(int id, String firstName, String lastName, String phoneNumber, String address, String email,
			String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public Customer() {

	}	
	public Customer(int id) {
		this.id=id;
	}
	public Customer(String firstName) {
		this.firstName=firstName;
	}
}
