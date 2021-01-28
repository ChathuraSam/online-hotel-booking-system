package com.hcl.ohbs.entities;

import java.util.Date;

public class Invoice {

	private Date dateGenerated;
	private double totalAmount;
	private int customerId;
	private int reservationId;
	public Date getDateGenerated() {
		return dateGenerated;
	}
	public void setDateGenerated(Date dateGenerated) {
		this.dateGenerated = dateGenerated;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public Invoice(Date dateGenerated, double totalAmount, int customerId, int reservationId) {
		super();
		this.dateGenerated = dateGenerated;
		this.totalAmount = totalAmount;
		this.customerId = customerId;
		this.reservationId = reservationId;
	}
	
	
}
