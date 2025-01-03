<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.Dao.Cart"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="com.tap.model.CartItem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<style>
/* Reset default styling */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

.empty-cart {
    text-align: center;
    padding: 40px 20px;
}

.empty-cart-image {
    max-width: 100%;
    height: auto;
    width: 200px;
    margin-bottom: 20px;
}

.empty-cart h1 {
    color: #555;
    font-size: 22px;
    margin-bottom: 20px;
}

.browse-button {
    display: inline-block;
    padding: 15px 30px;
    background-color: #fc8019;
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
    font-size: 18px;
    text-align: center;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.browse-button:hover {
    background-color: #e6780e;
}

body {
	background-color: #f5f5f5;
	color: #333;
}

h2 {
	color: #fc8019;
	font-size: 24px;
	margin-bottom: 20px;
	text-align: center;
}

.cart-container {
	width: 90%;
	max-width: 800px;
	margin: 30px auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

th, td {
	padding: 15px;
	text-align: left;
}

th {
	background-color: #fc8019;
	color: #fff;
	font-weight: normal;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr td {
	border-bottom: 1px solid #ddd;
}

.item-image {
    width: 60px;
    height: 60px;
    object-fit: cover;
    border-radius: 5px;
}

input[type="number"] {
	width: 50px;
	padding: 5px;
	border-radius: 4px;
	border: 1px solid #ddd;
}

.button {
	background-color: #fc8019;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 14px;
}

.button:hover {
	background-color: #e6780e;
}

.grand-total {
	font-size: 18px;
	text-align: right;
	margin-top: 15px;
	color: #333;
}

.checkout-button {
	width: 100%;
	background-color: #fc8019;
	color: white;
	padding: 15px;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
	text-align: center;
}

.checkout-button:hover {
	background-color: #e6780e;
}

.center-container {
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}
</style>
</head>
<body>

	<div class="cart-container">
		<h2>Your Shopping Cart</h2>

		<% 
        Cart cart = (Cart)session.getAttribute("cart"); 
        if (cart == null || cart.getItems().isEmpty()) {
    %>
		<div class="empty-cart">
        <img src="https://img.icons8.com/ios/452/shopping-cart.png" alt="Empty Cart" class="empty-cart-image">
        <h1>It feels so light. Add something from the menu</h1>
        <div class="center-container">
            <a href="Home.jsp" class="browse-button">Browse restaurants</a>
        </div>
    	</div>
		<% 
        } else {
            HashMap<Integer, CartItem> items = cart.getItems();
    %>
		<table cellpadding="10">
			<!-- <thead>
				<tr>
					<th>Image</th>
					<th>Item Name</th>
					<th>Price</th>
					<th>Subtotal</th>
					<th>Quantity</th>
					<th colspan="1">Update</th>
					<th>Delete</th>
				</tr>
			</thead> -->
			<tbody>
				<% 
            double sum = 0;
            for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
                CartItem item = entry.getValue();
                double subtotal = item.getPrice() * item.getQuantity();
                sum += subtotal;
        %>
				<tr>
					<%-- <td><img src="<% item.get%>" alt="<%= item.getName() %>" class="item-image"></td> --%>
					<td><%= item.getName() %></td>
					<td>₹<%= item.getPrice() %></td>
					<td>₹<%= subtotal %></td>
					<td>
						<form action="CartServ" method="post">
								<input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1"> 
								<input type="hidden" name="itemId" value="<%= item.getItemId() %>">
								<input type="hidden" name="itemQuantity" value="<%= item.getQuantity() %>">
					</td>
					<td>			
								<input type="submit" name="act" value="update" class="button">
							</span>
						</form>
					</td>
					<td>
						<form action="CartServ" method="post">
							<input type="hidden" name="itemId"
								value="<%= item.getItemId() %>"> <input type="hidden"
								name="itemQuantity" value="<%= item.getQuantity() %>"> <input
								type="submit" name="act" value="remove" class="button">
						</form>
					</td>
				</tr>
				<% 
            }
        %>
			</tbody>
		</table>

		<div class="grand-total">
			<h2>
				Grand Total: ₹<%= sum %></h2>
		</div>

		<div>
			<form action="Checkout.jsp" method="post">
				<input type="submit" value="Checkout" class="checkout-button">
			</form>
		</div>

		<% 
        }
    %>
	</div>

</body>
</html>
