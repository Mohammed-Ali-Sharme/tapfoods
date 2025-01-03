package com.tap.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tap.DaoI.Order1I;
import com.tap.model.Order1;

public class Order1Imp implements Order1I	
{
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet res;
	
	
	static final String INSERT_ORDER_DATA = "insert into order1 (userId,restaurantId,totalAmount,status,paymentOption) values(?,?,?,?,?)";
	static final String UPDATE_DATA_BY_ID = "update order1 set status = ? where order1Id = ?";
	static final String FETCH_DATA_BY_ID = "select * from order1 where order1Id = ?";
	static final String query = "select max(order1Id) from order1";
	
	
	
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
	public int insertOrder1(Order1 order) {
		int i = -1;
		try {
			pstmt = con.prepareStatement(INSERT_ORDER_DATA);
			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getRestaurantId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getStatus());
			pstmt.setString(5, order.getPaymentOption());
			 i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public Order1 fetchByOrderId(int order1Id) {
		Order1 o =null;
		try {
			pstmt = con.prepareStatement(FETCH_DATA_BY_ID);
			pstmt.setInt(1, order1Id);
			res = pstmt.executeQuery();
			while(res.next()) {
				o = new Order1(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),
						res.getString(5),res.getString(6),res.getString(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public int updateOrder(int orderid, String status) {
		int i =-1;
		try {
			pstmt = con.prepareStatement(UPDATE_DATA_BY_ID);
			pstmt.setInt(2, orderid);
			pstmt.setString(1, status);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	public int getOrderId()
	{
		int oId = -1;
		try {
			Statement stmt = con.createStatement();
			ResultSet res= stmt.executeQuery(query);
			res.next();
			oId = res.getInt(1);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return oId;
	}

	

}
