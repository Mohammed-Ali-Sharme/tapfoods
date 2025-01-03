<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment QR Code</title>
<style>
    /* Center the content and add some styling */
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
    }
    .container {
        text-align: center;
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
    }
    h2 {
        color: #333;
        margin-bottom: 15px;
    }
    .qr-code img {
        width: 200px;
        height: 200px;
        border: 1px solid #ddd;
        padding: 5px;
        border-radius: 8px;
        margin-bottom: 20px;
    }
    p {
        color: #666;
    }
    .instructions {
        color: #555;
        font-size: 14px;
        margin-top: 20px;
    }
    .back-btn {
        margin-top: 15px;
        display: inline-block;
        background-color: #4CAF50;
        color: #fff;
        padding: 10px 20px;
        border-radius: 5px;
        text-decoration: none;
        transition: background-color 0.3s ease;
    }
    .back-btn:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

<% 
    // Assume QR code URL is stored as an attribute or session variable
    String qrCodeUrl = (String) request.getAttribute("qrCodeUrl"); 
    if (qrCodeUrl == null) {
        qrCodeUrl = "path/to/default_qr_code.png"; // Fallback image if no QR code is provided
    }
%>

<div class="container">
    <h2>Scan to Pay</h2>
    
    <div class="qr-code">
        <img src="<%= qrCodeUrl %>" alt="QR Code for Payment">
    </div>
    
    <p>Scan the QR code above using any UPI-enabled app to make the payment.</p>
    
    <div class="instructions">
        <p>Once the payment is completed, please return to the checkout page to finalize your order.</p>
    </div>
    
    <a href="Sucess.jsp" class="back-btn">Next Step</a>
</div>

</body>
</html>
