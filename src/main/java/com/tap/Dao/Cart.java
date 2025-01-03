package com.tap.Dao;

import java.util.HashMap;
import java.util.Map;

import com.tap.model.CartItem;

public class Cart {
	private HashMap<Integer,CartItem> items;

	public Cart()
	{
		this.items = new HashMap<Integer, CartItem>();
	}
	
	public void addItem(CartItem item)
	{
		int itemId = item.getItemId();
		if(items.containsKey(itemId))
		{
			CartItem cI = items.get(itemId);
			cI.setQuantity(item.getQuantity()+cI.getQuantity());
		}
		else
		{
			items.put(itemId,item);
		}
	}
	public void updateItem(int itemId, int quantity)
	{
		if(items.containsKey(itemId))
		{
			if(quantity<=0)
			{
				items.remove(itemId);
			}
			else
			{
				items.get(itemId).setQuantity(quantity);
			}
		}
	}
	public void removeItem(int itemId)
	{
		items.remove(itemId);
	}
	public Map<Integer, CartItem> getItem()
	{
		
		return items;
	}
	public void clear()
	{
		items.clear();
	}

	public HashMap<Integer, CartItem> getItems() {
		return items;
	}

	public void setItems(HashMap<Integer, CartItem> items) {
		this.items = items;
	}
	
	
	
	

}
