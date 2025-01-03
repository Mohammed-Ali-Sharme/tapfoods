package com.tap.DaoI;

import java.util.List;
import com.tap.model.Menu;


public interface MenuDaoI {
	int insertMenu(Menu u);
	List<Menu> getAllRestaurantMenu(int restaurantId);
	Menu getMenuById(int id);
	int updateMenuById(int id,boolean isAvailable);
	int deleteMenuById(int id);

}
