package com.hcl.ohbs.entities;
public class HotelImage {
	private Hotel hotel;
	private String images;
	public HotelImage() {

	}	
	public HotelImage(Hotel hotel, String images) {
		super();
		this.hotel = hotel;
		this.images = images;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}	
}
