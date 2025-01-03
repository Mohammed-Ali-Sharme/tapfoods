package com.tap.DaoI;

import com.tap.model.OrderItem;

public interface OrderItemI {
	int insertOrderItem(OrderItem orderItem);
	OrderItem fetchOrderItem(int orderId);
	
}
