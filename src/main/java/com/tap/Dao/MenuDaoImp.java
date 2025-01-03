package com.tap.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.DaoI.MenuDaoI;
import com.tap.model.Menu;

public class MenuDaoImp implements MenuDaoI{
	
	
	static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet resultSet;
	int x;
	List<Menu> list = new ArrayList<Menu>();
	private static String insert_Menu = "insert into menu(restaurantId,itemName,description,price,isAvailable,imagePath) values(?,?,?,?,?,?)";
	private static String get_All_Restaurant_Menu = "select * from menu where restaurantId = ?";
	private static String get_Menu_By_Id = "select * from menu where menuId = ?";
	private static String update_Menu_By_Id = "update menu set isAvailable = ? where menuId = ?";
	private static String delete_Menu_By_Id = "delete from menu where menuId = ?";
	
	
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
	public int insertMenu(Menu menu) {
		
		try
		{	
			pstmt = con.prepareStatement(insert_Menu);
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setFloat(4, menu.getPrice());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setString(6, menu.getImgPath());
			
			x = pstmt.executeUpdate();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<Menu> getAllRestaurantMenu(int restaurantId) {
		
		try
		{
			pstmt = con.prepareStatement(get_All_Restaurant_Menu);
			pstmt.setInt(1, restaurantId);
			resultSet = pstmt.executeQuery();
			list = extractListFromResultSet(resultSet);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public Menu getMenuById(int menuId) {

		try 
		{
			pstmt = con.prepareStatement(get_Menu_By_Id);
			pstmt.setInt(1, menuId);
			resultSet = pstmt.executeQuery();
			list = extractListFromResultSet(resultSet);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list.get(0);
	}

	@Override
	public int updateMenuById(int id, boolean isAvailable) {

		try 
		{
			pstmt = con.prepareStatement(update_Menu_By_Id);
			pstmt.setInt(2, id);
			pstmt.setBoolean(1, isAvailable);
			x = pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public int deleteMenuById(int menuId) {

		try 
		{
			pstmt = con.prepareStatement(delete_Menu_By_Id);
			pstmt.setInt(1, menuId);
			x = pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return x;
	}
	List<Menu> extractListFromResultSet(ResultSet resultSet) {
		
		
		try
		{
			while(resultSet.next())
			{
				list.add(new Menu(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),
				resultSet.getFloat(5), resultSet.getBoolean(6), resultSet.getString(7)));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
