package com.tap.model;

public class OrderItem {
	
	private int orderItemId;
	private int order1Id;
	private int menuId;
	private int quantity;
	private double subTotal;
	
	
	public OrderItem() {

		
	}


	public OrderItem(int order1Id, int menuId, int quantity, double subTotal) {
		super();
		this.order1Id = order1Id;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}


	public OrderItem(int orderItemId, int order1Id, int menuId, int quantity, double subTotal) {
		super();
		this.orderItemId = orderItemId;
		this.order1Id = order1Id;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}


	public int getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}


	public int getOrder1Id() {
		return order1Id;
	}


	public void setOrder1Id(int order1Id) {
		this.order1Id = order1Id;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	@Override
	public String toString() {
		return orderItemId + "  " + order1Id + "  " + menuId + "  " + quantity + "  " + subTotal ;
	}
	
	

}
