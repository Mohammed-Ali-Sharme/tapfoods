package com.tap.DaoI;

import java.sql.ResultSet;
import java.util.List;

import com.tap.model.User;

public interface UserDaoI {
	int insertUser(User u);
	List<User> getAllUsers();
	User getUserById(int id);
	User getUserByEmail(String email);
	int updateUserById(int id,String address);
	int deleteUserById(int id);
}
