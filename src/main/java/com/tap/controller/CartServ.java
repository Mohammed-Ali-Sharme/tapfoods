package com.tap.controller;

import java.io.IOException;

import com.tap.Dao.Cart;
import com.tap.Dao.MenuDaoImp;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartServ extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int itemId = Integer.parseInt(req.getParameter("itemId"));
//		session.setAttribute("menuId", itemId);
		Cart cart =(Cart)session.getAttribute("cart");
		if(cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		String action = req.getParameter("act");
		if("add".equals(action))
		{
			addItemToCart(req,cart);
			session.setAttribute("cart", cart);
			resp.sendRedirect("Menu.jsp");
		}
		else if("update".equals(action))
		{
			updateItemToCart(req,cart);
			resp.sendRedirect("Cart.jsp");
		}
		else if("remove".equals(action))
		{
			removeItemFromCart(req,cart);
			resp.sendRedirect("Cart.jsp");
		}
			
	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("itemQuantity"));
		MenuDaoImp menuDao = new MenuDaoImp();
		Menu menuItem = menuDao.getMenuById(itemId);
		HttpSession session = req.getSession();
		session.setAttribute("restaurantId",menuItem.getRestaurantId());
		if(menuItem != null)
		{
			CartItem item = new CartItem(menuItem.getMenuId(), 
					menuItem.getRestaurantId(), 
					menuItem.getItemName(), 
					quantity, 
					menuItem.getPrice()); 
			cart.addItem(item);
		}
		
		
	}
	private void removeItemFromCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		cart.removeItem(itemId);
	}

	private void updateItemToCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		cart.updateItem(itemId,quantity);
	}

}
