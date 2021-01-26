package com.hcl.ohbs.entities;



public class Reservation {
	private int id;
	private String checkIn;
	private String checkOut;
	private int noOfPersons;
	private Customer customer;
	private Hotel hotel;
	public Reservation() {

	}
	public Reservation(String checkIn, String checkOut, int noOfPersons, Customer customer, Hotel hotel) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.noOfPersons = noOfPersons;
		this.customer = customer;
		this.hotel = hotel;
	}
	public Reservation(int id, String checkIn, String checkOut, int noOfPersons, Customer customer, Hotel hotel) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.noOfPersons = noOfPersons;
		this.customer = customer;
		this.hotel = hotel;
	}
	public Reservation(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public int getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
