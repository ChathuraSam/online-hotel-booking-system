package com.hcl.ohbs.entities;

public class Room {
	private int id;
	private String name;
	private Double price;
	private String features;
	private int noOfPersons;
	private int isAvailable;
	private Hotel hotel;
	public Room() {

	}
	public Room(String name, Double price, String features, int noOfPersons, int isAvailable, Hotel hotel) {
		this.name = name;
		this.price = price;
		this.features = features;
		this.noOfPersons = noOfPersons;
		this.isAvailable = isAvailable;
		this.hotel = hotel;
	}
	public Room(int id, String name, Double price, String features, int noOfPersons, int isAvailable, Hotel hotel) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.features = features;
		this.noOfPersons = noOfPersons;
		this.isAvailable = isAvailable;
		this.hotel = hotel;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public int getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", price=" + price + ", features=" + features + ", noOfPersons="
				+ noOfPersons + ", isAvailable=" + isAvailable + ", hotel=" + hotel + "]";
	}	
}
