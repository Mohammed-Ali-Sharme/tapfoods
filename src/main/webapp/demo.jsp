<%@page import="org.apache.el.parser.AstDiv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.tap.model.Menu" %> 
<%@ page import = "com.tap.Dao.RestaurantDaoImp" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.tap.Dao.RestaurantDaoImp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="icon" href="data:image/jpeg;base64,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">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Website</title>
    <style>
        /* General reset and body styles */
        body, h1, p, div {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
        }

        /* Navbar styles */
        .navbar {
            background-color: #333;
            overflow: hidden;
            position: relative;
            padding: 10px 20px;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            padding: 14px 20px;
            display: inline-block;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        /* Cart button positioned at top-right */
        #bars {
            position: absolute;
            top: 10px;
            right: 20px;
            background-color: #333;
            color: white;
            padding: 10px 15px;
            border-radius: 50%;
            cursor: pointer;
        }

        /* Add a hover effect for cart button */
        #bars:hover {
            background-color: #444;
        }

        /* Make sure the rest of the page is styled correctly */
        .content {
            padding-top: 60px;  /* Add some space for navbar and cart */
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="#home">Home</a>
        <a href="#about">About</a>
        <a href="#contact">Contact</a>
        <!-- Cart button in the top-right corner -->
        <div id="bars">
            <i class="fa fa-shopping-cart"></i>
        </div>
    </div>

    <div class="content">
        <h1>Welcome to Our Website</h1>
        <p>Here is some content for the page.</p>
    </div>
</body>
</html>
