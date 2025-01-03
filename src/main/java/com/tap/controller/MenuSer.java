package com.tap.controller;

import java.io.IOException;
import java.util.List;

import com.tap.Dao.MenuDaoImp;
import com.tap.Dao.RestaurantDaoImp;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class MenuSer extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int resId = Integer.parseInt(req.getParameter("resId"));
				MenuDaoImp menuDaoImp = new MenuDaoImp();
				RestaurantDaoImp restaurantDaoImp = new RestaurantDaoImp();
				Restaurant restaurantById = restaurantDaoImp.getRestaurantById(resId);
				String resName = restaurantById.getRestaurantName();
				List<Menu> menuList = menuDaoImp.getAllRestaurantMenu(resId);
		HttpSession session = req.getSession();
		session.setAttribute("menuList", menuList);
		session.setAttribute("resName", resName);
		session.setAttribute("resId", resId);
		resp.sendRedirect("Menu.jsp");
	}

}








