package com.tap.DaoI;

import com.tap.model.Order1;

public interface Order1I {
	
	int insertOrder1(Order1 o);
	Order1 fetchByOrderId(int orderId);
	int updateOrder(int orderId,String status);

}
