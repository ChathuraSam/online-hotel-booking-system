package com.hcl.ohbs.entities;



public class Reservation {
	private int id;
	private String checkIn;
	private String checkOut;
	private int noOfPersons;
	private Customer customer;
	private Room room;
	public Reservation() {

	}
	public Reservation(String checkIn, String checkOut, int noOfPersons, Customer customer, Room room) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.noOfPersons = noOfPersons;
		this.customer = customer;
		this.room = room;
	}
	public Reservation(int id, String checkIn, String checkOut, int noOfPersons, Customer customer, Room room) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.noOfPersons = noOfPersons;
		this.customer = customer;
		this.room = room;
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
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", noOfPersons="
				+ noOfPersons + ", customer=" + customer + ", room=" + room + "]";
	}
}
