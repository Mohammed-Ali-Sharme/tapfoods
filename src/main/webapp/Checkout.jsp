
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.tap.Dao.Cart" %>   
<%@ page import = "java.util.HashMap" %>   
<%@ page import = "java.util.Map" %>   
<%@ page import = "com.tap.model.CartItem" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<style>
    /* Basic reset and styling */
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
    }
    
    /* Main container styling */
    .container {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        padding: 20px;
        max-width: 500px;
        width: 100%;
    }

    h2 {
        color: #333;
        text-align: center;
        border-bottom: 2px solid #f0f0f0;
        padding-bottom: 10px;
    }

    /* Grand Total section */
    .total {
        font-size: 18px;
        color: #333;
        font-weight: bold;
        text-align: center;
        margin-bottom: 20px;
    }

    /* Form styling */
    form div {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
        color: #555;
    }

    textarea {
        width: 100%;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        resize: vertical;
    }

    input[type="radio"] {
        margin-right: 10px;
    }

    /* Submit button styling */
    .submit-btn {
        background-color: #4CAF50;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        text-align: center;
        width: 100%;
    }

    .submit-btn:hover {
        background-color: #45a049;
    }

    /* Empty cart message */
    .empty-message {
        text-align: center;
        color: #888;
        font-size: 16px;
    }
</style>
</head>
<body>

    <div class="container">
        <h2>Checkout</h2>
        
        <% 
            // Get the cart from session
            Cart cart = (Cart)session.getAttribute("cart"); 
            
            // If cart is empty, display a message
            if (cart == null || cart.getItems().isEmpty()) {
        %>
                <p class="empty-message">Your cart is empty!</p>
        <% 
            } else {
                
                // Get items from the cart
                HashMap<Integer, CartItem> items = cart.getItems();
                double sum = 0;
                for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
                    CartItem item = entry.getValue();
                    sum += item.getPrice() * item.getQuantity(); // Calculate total
                }
        %>
        
        <!-- Form to collect address and payment information -->
        <form action="CheckoutSer" method="post">
            
            <!-- Display Grand Total -->
            <div class="total">
                <h3>Grand Total: Rs:<%= String.format("%.2f", sum) %></h3>
            </div>
            
            <!-- Address Field -->
            <div>
                <label for="address">Shipping Address:</label>
                <textarea name="address" id="address" rows="4" placeholder="Enter your address" required></textarea>
            </div>
            
            <!-- Payment Mode -->
            <div>
                <h4>Select Payment Mode:</h4>
                <label><input type="radio" id="upi" name="paymentMode" value="UPI" required> UPI</label><br>
                <label><input type="radio" id="card" name="paymentMode" value="Card" required> Debit/Credit Card</label><br>
                <label><input type="radio" id="cod" name="paymentMode" value="COD" required> Cash on Delivery</label>
            </div>
            
            <!-- Hidden Cart Data (optional) -->
            <input type="hidden" name="totalAmount1" value="<%= sum %>">
            
            <!-- Submit Button to place the order -->
            <div>
                <input type="submit" value="Place Order" class="submit-btn">
            </div>
        </form>
        
        <% 
            }
        %>
        
    </div>

</body>
</html>
