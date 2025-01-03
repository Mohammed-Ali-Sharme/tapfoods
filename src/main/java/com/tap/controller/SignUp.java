package com.tap.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tap.Dao.UserDaoImp;
import com.tap.model.User;

public class SignUp extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		User user = new User(userName, email, password, address);
		UserDaoImp userDaoImp = new UserDaoImp();
		int x = userDaoImp.insertUser(user);
		if(x == 0)
		{
			resp.sendRedirect("signup.html");
		}
		else
		{
			resp.sendRedirect("login.html");
		}
	}

}
