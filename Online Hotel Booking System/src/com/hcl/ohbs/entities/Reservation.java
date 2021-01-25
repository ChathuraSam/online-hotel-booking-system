package com.hcl.ohbs.entities;

import java.util.Date;

public class Reservation {
	private int id;
	private Date checkIn;
	private Date checkOut;
	private int noOfPersons;
	private Customer customer;
	private Hotel hotel;
	public Reservation() {

	}
	public Reservation(Date checkIn, Date checkOut, int noOfPersons, Customer customer, Hotel hotel) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.noOfPersons = noOfPersons;
		this.customer = customer;
		this.hotel = hotel;
	}
	public Reservation(int id, Date checkIn, Date checkOut, int noOfPersons, Customer customer, Hotel hotel) {
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
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
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
