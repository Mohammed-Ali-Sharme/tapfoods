package com.tap.model;

public class Order1 {
	private int order1Id;
	private int userId;
	private int restaurantId;
	private double totalAmount;
	private String status;
	private String date;
	private String paymentOption;
	
	
	public Order1() {
		
	}


	public Order1(int userId, int restaurantId, double totalAmount, String status, String paymentOption) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentOption = paymentOption;
	}


	public Order1(int order1Id, int userId, int restaurantId, double totalAmount, String status, String date,
			String paymentOption) {
		super();
		this.order1Id = order1Id;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.date = date;
		this.paymentOption = paymentOption;
	}


	public int getOrder1Id() {
		return order1Id;
	}


	public void setOrder1Id(int order1Id) {
		this.order1Id = order1Id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getPaymentOption() {
		return paymentOption;
	}


	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}


	@Override
	public String toString() {
		return order1Id + "  " + userId + "  " + restaurantId + "  " + totalAmount + "  " + status +
				"  " + date + "  "+ paymentOption;
	}
	
	
	
	
	
	

}
