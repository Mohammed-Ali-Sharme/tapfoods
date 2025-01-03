package com.tap.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DaoI.RestaurantDaoI;
import com.tap.model.Restaurant;


public class RestaurantDaoImp implements RestaurantDaoI
{

	static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet resultSet;
	int x;
	List<Restaurant> list = new ArrayList<Restaurant>();
	private static String insert_Resaturant = "insert into Restaurant(restaurantName,cuisineType,moblieNo,address,city,isActive,ratings,image) values(?,?,?,?,?,?,?,?)";
	private static String get_All_Restaurant = "select * from restaurant";
	private static String get_Restaurant_By_Id = "select * from restaurant where restaurantId = ?";
	private static String update_Restaurant_By_Id = "update restaurant set isActive = ? where restaurantId = ?";
	private static String delete_Restaurant_By_Id = "delete from restaurant where restaurantId = ?";
	
	
	static
	{
		try
		{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery","root","Ali#1234");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	@Override
	public int insertRestaurant(Restaurant restaurant) {
		
		try
		{	
			pstmt = con.prepareStatement(insert_Resaturant);
			pstmt.setString(1, restaurant.getRestaurantName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setString(3, restaurant.getMoblieNo());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setString(5, restaurant.getCity());
			pstmt.setBoolean(6, restaurant.getIsActive());
			pstmt.setString(7, restaurant.getRatings());
			pstmt.setString(8, restaurant.getImage());
			x = pstmt.executeUpdate();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		
		try
		{	
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(get_All_Restaurant);
			list = extractListFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public Restaurant getRestaurantById(int id) {
		
		try
		{
			pstmt = con.prepareStatement(get_Restaurant_By_Id);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			list = extractListFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list.get(0);
	}

	@Override
	public int updateRestaurantById(int id, boolean isActive) {
		try
		{
			pstmt = con.prepareStatement(update_Restaurant_By_Id);
			pstmt.setInt(2, id);
			pstmt.setBoolean(1, isActive);
			x = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int deleteUserById(int id) {
		
		try
		{
			pstmt = con.prepareStatement(delete_Restaurant_By_Id);
			pstmt.setInt(1, id);
			x = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
		
	}
	
	List<Restaurant> extractListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				list.add(new Restaurant(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
						resultSet.getString(6),resultSet.getBoolean(7),resultSet.getString(8),
						resultSet.getString(9)));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
}
