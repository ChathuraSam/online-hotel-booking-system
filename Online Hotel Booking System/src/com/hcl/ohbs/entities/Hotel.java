package com.hcl.ohbs.entities;

public class Hotel {
	private int id;
	private String name;
	private String city;
	private String phoneNumber;
	private String address;
	private String status;
	private int maximum_capacity;
	private int available_capacity;
	private HotelOwner hotelOwner;
	private String category;
	private String features;
	private double price;
	public Hotel() {

	}
	
	//this constructor is for populating the home page. Don't delete
	public Hotel(String name, String city, String phone, String address) {
		this.name = name;
		this.city = city;
		this.phoneNumber = phone;
		this.address = address;
	}
	
	
	public Hotel(String name, String city, String phoneNumber, String address, String status, int maximum_city,
			int available_city, HotelOwner hotelOwner, String category, String features,
			double price) {
		this.name = name;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.status = status;
		this.maximum_capacity = maximum_city;
		this.available_capacity = available_city;
		this.hotelOwner = hotelOwner;
		this.category = category;
		this.features = features;
		this.price = price;
	}
	public Hotel(int id, String name, String city, String phoneNumber, String address, String status, int maximum_capacity,
			int available_capacity, HotelOwner hotelOwner, String category, String features,
			double price) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.status = status;
		this.maximum_capacity = maximum_capacity;
		this.available_capacity = available_capacity;
		this.hotelOwner = hotelOwner;
		this.category = category;
		this.features = features;
		this.price = price;
	}
	public Hotel(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMaximum_capacity() {
		return maximum_capacity;
	}
	public void setMaximum_capacity(int maximum_capacity) {
		this.maximum_capacity = maximum_capacity;
	}
	public int getAvailable_capacity() {
		return available_capacity;
	}
	public void setAvailable_capacity(int available_capacity) {
		this.available_capacity = available_capacity;
	}
	public HotelOwner getHotelOwner() {
		return hotelOwner;
	}
	public void setHotelOwner(HotelOwner hotelOwner) {
		this.hotelOwner = hotelOwner;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", city=" + city + ", phoneNumber=" + phoneNumber + ", address="
				+ address + "]";
	}	
	
	
}