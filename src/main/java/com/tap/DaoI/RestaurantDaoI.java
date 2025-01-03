package com.tap.DaoI;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDaoI {

	int insertRestaurant(Restaurant u);
	List<Restaurant> getAllRestaurant();
	Restaurant getRestaurantById(int id);
	int updateRestaurantById(int id,boolean isActive);
	int deleteUserById(int id);

}
