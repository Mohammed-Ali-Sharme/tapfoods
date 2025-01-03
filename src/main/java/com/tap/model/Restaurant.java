package com.tap.model;

public class Restaurant
{
	private int restaurantId;
	private String restaurantName;
	private String cuisineType;
	private String moblieNo;
	private String address;
	private String city;
	private boolean isActive;
	private String ratings;
	private String image;
	
	
	public Restaurant() {
		super();
	}


	public Restaurant(int restaurantId, String restaurantName, String cuisineType, String moblieNo, String address,
			String city, boolean isActive, String ratings, String image) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.cuisineType = cuisineType;
		this.moblieNo = moblieNo;
		this.address = address;
		this.city = city;
		this.isActive = isActive;
		this.ratings = ratings;
		this.image = image;
	}


	public Restaurant(String restaurantName, String cuisineType, String moblieNo, String address, String city,
			boolean isActive, String ratings, String image) {
		super();
		this.restaurantName = restaurantName;
		this.cuisineType = cuisineType;
		this.moblieNo = moblieNo;
		this.address = address;
		this.city = city;
		this.isActive = isActive;
		this.ratings = ratings;
		this.image = image;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	public String getMoblieNo() {
		return moblieNo;
	}


	public void setMoblieNo(String moblieNo) {
		this.moblieNo = moblieNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}


	public String getRatings() {
		return ratings;
	}


	public void setRatings(String ratings) {
		this.ratings = ratings;
	}


	@Override
	public String toString() {
		return restaurantId + " " + restaurantName + " " + cuisineType + " " + moblieNo + " " + address + " " + city
				+ " " + isActive + " " + ratings;
	}
	
	
	
	
}