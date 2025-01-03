package com.tap.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tap.DaoI.OrderItemI;
import com.tap.model.OrderItem;


public class OrderItemImp implements OrderItemI 
{
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet res;
	
	static final String INSERT_ORDER_DATA = "insert into orderitem (order1Id,menuId,quantity,subtotal) values(?,?,?,?)";
	static final String FETCH_DATA_BY_ID = "select * from orderitem where orderItemId = ?";
	
	static {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","Ali#1234");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertOrderItem(OrderItem orderItem) {
		int i = -1;
		try {
			pstmt = con.prepareStatement(INSERT_ORDER_DATA);
			pstmt.setInt(1, orderItem.getOrder1Id());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setDouble(4, orderItem.getSubTotal());
			 i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public OrderItem fetchOrderItem(int orderItemId) {
		OrderItem o =null;
		try {
			pstmt = con.prepareStatement(FETCH_DATA_BY_ID);
			pstmt.setInt(1, orderItemId);
			res = pstmt.executeQuery();
			if(res.next()) {
				o = new OrderItem(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),
						res.getDouble(5));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}
