package com.tap.controller;

import java.io.IOException;
import java.sql.ResultSet;

import com.tap.Dao.UserDaoImp;
import com.tap.DaoI.UserDaoI;
import com.tap.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private User user;
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		try
		{
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			UserDaoI userDao =  new UserDaoImp();
			user = userDao.getUserByEmail(email);
			if(user != null)
			{
				String pass = user.getPassword();
				String userName = user.getUserName();
				int userId = user.getUserId();
				if(pass.equals(password))
				{
					session = req.getSession();
					session.setAttribute("userName", userName);
					session.setAttribute("userId",userId);
					
					resp.sendRedirect("RestaurantList");
				}
				else
				{
					resp.sendRedirect("failure.html");
				}
			}
			else
			{
				resp.sendRedirect("failure.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
