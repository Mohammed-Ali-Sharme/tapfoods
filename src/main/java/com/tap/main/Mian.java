package com.tap.main;

import com.tap.Dao.Order1Imp;
import com.tap.model.Order1;

public class Mian {
	public static void main(String[] args) {
		Order1 order = new Order1(1,1,40.5f,"pending","upi");
		Order1Imp order1 = new Order1Imp();
		System.out.println(order1.updateOrder(1, "delivered"));
		
	}

}
