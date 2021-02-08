package com.hcl.ohbs.entities;

import java.util.*;

public class Invoice {
	
	private int id;
	private Date dateGenerated;
	private double totalAmount;
	private int customerId;
	private int reservationId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Invoice(double totalAmount, int customerId, int reservationId) {
		super();
		this.totalAmount = totalAmount;
		this.customerId = customerId;
		this.reservationId = reservationId;
	}
	public Invoice(int id, Date dateGenerated, double totalAmount, int customerId, int reservationId) {
		super();
		this.id = id;
		this.dateGenerated = dateGenerated;
		this.totalAmount = totalAmount;
		this.customerId = customerId;
		this.reservationId = reservationId;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", dateGenerated=" + dateGenerated + ", totalAmount=" + totalAmount
				+ ", customerId=" + customerId + ", reservationId=" + reservationId + "]";
	}
}
