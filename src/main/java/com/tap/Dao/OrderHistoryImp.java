package com.tap.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DaoI.OrderHistoryI;
import com.tap.model.OrderHistory;

public class OrderHistoryImp implements OrderHistoryI{
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet res;
	private List<OrderHistory> list = new ArrayList<OrderHistory>();
	

	static final String INSERT_ORDER_DATA = "insert into orderhistory (userId,order1Id,total,status) values(?,?,?,?)";
	static final String UPDATE_DATA_BY_ID = "update orderhistory set status = ? where orderHistoryId = ?";
	static final String FETCH_DATA_BY_ID = "select * from orderhistory where orderHistoryId = ?";
	static final String FETCH_ON_USER_ID = "select * from orderHistory where userId = ?";

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
	public List<OrderHistory> fechOnUserId(int userId) {
		try 
		{	
			PreparedStatement pstmt = con.prepareStatement(FETCH_ON_USER_ID);
			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery();
			return extractListFromResultSet(res);
			
		}
		catch (Exception e) 
		{
			
		}
		return null;
	}
	
	@Override
	public OrderHistory fetchOrderOnId(int orderHistoryId) {
		OrderHistory oh =null;
		try {
			pstmt = con.prepareStatement(FETCH_DATA_BY_ID);
			pstmt.setInt(1, orderHistoryId);
			res = pstmt.executeQuery();
			if(res.next()) {
				oh = new OrderHistory(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getDouble(5),
						res.getString(6));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return oh;
	}

	@Override
	public int insertOrderHistory(OrderHistory orderHistory) {
		int i = -1;
		try {
			pstmt = con.prepareStatement(INSERT_ORDER_DATA);
			pstmt.setInt(1, orderHistory.getUserId());
			pstmt.setInt(2, orderHistory.getOrderId());
			pstmt.setDouble(3, orderHistory.getTotal());
			pstmt.setString(4, orderHistory.getStatus());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateOrderHistory(int orderHistoryid, String status) {
		int i =-1;
		try {
			pstmt = con.prepareStatement(UPDATE_DATA_BY_ID);
			pstmt.setInt(2, orderHistoryid);
			pstmt.setString(1, status);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	List<OrderHistory> extractListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				list.add(new OrderHistory(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
						resultSet.getString(4),resultSet.getDouble(5),resultSet.getString(6)));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
