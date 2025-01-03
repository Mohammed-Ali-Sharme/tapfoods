package com.tap.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tap.DaoI.UserDaoI;
import com.tap.model.User;

public  class UserDaoImp implements UserDaoI
{
	static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet resultSet;
	int x;
	List<User> list = new ArrayList<User>();
	private static String insert_User = "insert into user(username,password,email,address) values(?,?,?,?)";
	private static String get_All_Users = "select * from user";
	private static String get_User_By_Id = "select * from user where user_Id = ?";
	private static String get_User_By_email = "select * from user where email = ?";
	private static String update_Address_By_Id = "update user set address = ? where user_Id = ?";
	private static String delete_User_By_Id = "delete from user where user_Id = ?";
	
	
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
	public int insertUser(User user) {
		
		try
		{	
			pstmt = con.prepareStatement(insert_User);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			x = pstmt.executeUpdate();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public List<User> getAllUsers() {
		try
		{	
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(get_All_Users);
			list = extractListFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User getUserById(int id) {
		try
		{
			pstmt = con.prepareStatement(get_User_By_Id);
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
	public User getUserByEmail(String email) {
		User user = null;
		try 
		{
			pstmt = con.prepareStatement(get_User_By_email);
			pstmt.setString(1, email);
			resultSet = pstmt.executeQuery();
			resultSet.next();
			user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
				resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int updateUserById(int id, String address) {
		try
		{
			pstmt = con.prepareStatement(update_Address_By_Id);
			pstmt.setInt(2, id);
			pstmt.setString(1, address);
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
			pstmt = con.prepareStatement(delete_User_By_Id);
			pstmt.setInt(1, id);
			x = pstmt.executeUpdate();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}
	
	List<User> extractListFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				list.add(new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
				resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}



