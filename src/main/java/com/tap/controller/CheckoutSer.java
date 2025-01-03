package com.tap.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.tap.Dao.Cart;
import com.tap.Dao.Order1Imp;
import com.tap.Dao.OrderHistoryImp;
import com.tap.Dao.OrderItemImp;
import com.tap.model.CartItem;
import com.tap.model.Order1;
import com.tap.model.OrderHistory;
import com.tap.model.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class CheckoutSer extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		int userId = (int)session.getAttribute("userId");
		int resId = (int)session.getAttribute("resId");
//		double totalAmount = Double.parseDouble(req.getAttribute("totalAmount1"));
		double totalAmount = Double.parseDouble(req.getParameter("totalAmount1"));
		String status = "delivered";
		String paymentMode = (String)req.getAttribute("paymentMode");
		Order1 order1 = new Order1(userId, resId, totalAmount, status, paymentMode);
		Order1Imp order1Imp = new Order1Imp();
		order1Imp.insertOrder1(order1);
		int order1Id = order1Imp.getOrderId();
		OrderHistory orderHistory = new OrderHistory(userId, order1Id, totalAmount, status);
		OrderHistoryImp orderHistoryImp = new OrderHistoryImp();
		orderHistoryImp.insertOrderHistory(orderHistory);
		OrderItemImp orderItemDao = new OrderItemImp();
		Cart cart = (Cart)session.getAttribute("cart");
        
        if (cart != null) {
        	HashMap<Integer, CartItem> items = cart.getItems();
            double sum = 0;
            for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
                CartItem item = entry.getValue();
                int menuId = entry.getKey();
                
                int quantity = item.getQuantity();
                double subTotal = item.getPrice() * quantity;
                OrderItem orderItem = new OrderItem(order1Id, menuId, quantity, subTotal);
                orderItemDao.insertOrderItem(orderItem);
            }
            
            resp.sendRedirect("Sucess.jsp");
        }
	}
       

}
