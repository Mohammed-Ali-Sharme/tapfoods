package com.tap.controller;

import java.io.IOException;
import java.util.List;

import com.tap.Dao.RestaurantDaoImp;
import com.tap.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class RestaurantList extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		RestaurantDaoImp res = new RestaurantDaoImp();
		List<Restaurant> resList = res.getAllRestaurant();
		HttpSession session = req.getSession();
		session.setAttribute("resList", resList);
		resp.sendRedirect("Home.jsp");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
