<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.tap.model.Restaurant" %> 
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
    <title>Welcome Page</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: "Poppins", serif;
        }
        .flex{
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            color: white;
        }
        .navbar{
            width: 100%;
            padding: 5px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: #FF5200;
        }
        .navbar .logo img{
            width: 100px;
        }
        .navbar .links {
            display: flex;
            align-items: center;
            column-gap: 30px;
            margin-left:600px;
        }
        .navbar .links a{
            padding: 8px 30px;
            background: transparent;
            color: white;
            text-decoration: none;
            border: 1.5px solid white;
            border-radius: 10px;
            font-weight: 700;
            transition: background-color 0.3s ease, color 0.3s ease;
                       
        }
        .navbar .links a:hover {
    		background-color: white; /* Reverse color on hover */
    		color: #FF5200;
}
        .navbar h1{
            font-weight: 600;
            color: white;
            margin-left: 50px;
        }
        .navbar #bars i{
            font-size: 25px;
            color: white;
        }
        .restarents{
            width: 100%;
            display: flex;
            justify-content: flex-start;
            align-items: center;
            column-gap: 20px;
            row-gap: 10px; 
            flex-wrap: wrap;
            padding: 10px 35px;;
        }
        a{
            text-decoration: none;
            
        }
        .flex2{
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .flex3{
            display: flex;
            align-items: center;
            column-gap: 2px;
        }
        .padd{
            padding: 1px 10px;
        }
        .card{
            width: 345px;
            border-radius: 10px;
            margin-top: 20px;
            position: relative;
            box-shadow: 0 0 4px black;
            padding-bottom: 10px;
            object-fit: cover;
            transition: transform 0.5s ease, ;
        }
	        .card:hover {
    		background-color: #f5f5f5; /* Change background on hover */
    		box-shadow: 0 0 10px #FF5200;/* Add a glow effect */
        
}
       	    .card .rest .restrent-image{
            width: 100%;
            border-radius: 10px 10px 0 0;
	    	object-fit: cover;
   	 		/* transition: transform 0.3s ease; */
            
        }
        .card .rest .restarent-name{
            position: absolute;
            left: 10px;
            top:185px;
            color: white;
            font-weight: 500;
        }
         .active {
            color: green;
        }
        .inactive {
            color: red;
        }
        .card .rest .restrent-image{
    	width: 100%;
    	height: 230px; 
    	border-radius: 10px 10px 0 0;
		}
        
    </style>
</head>
<body>
    <div class="navbar">
        <div class="logo flex">
            <img src="https://th.bing.com/th/id/OIP.GsWJopJ1ZjT7Te8sQd8eDQHaDa?rs=1&pid=ImgDetMain" alt="">
            <p>Foodies</p>
        </div>
            <h1>Welcome Foodies</h1>
        <div class="links">
            <a href="login.html">Login</a>
            <a href="signup.html">Sign Up</a>
        </div>
        <div id="bars">
            <i class="fa-solid fa-bars-staggered"></i>
        </div>
    </div>
<div class="restarents">
    <!-- Card Start -->
    <%
    	RestaurantDaoImp ress = new RestaurantDaoImp();
            List<Restaurant> resList = ress.getAllRestaurant();
            if (resList != null && !resList.isEmpty()) {
                for (Restaurant res : resList) {
        %>
	<a href="MenuSer?resId=<%=res.getRestaurantId()%>">
    <div class="card">
        <div class="rest">
            <img class="restrent-image" src="<%= res.getImage()%>">
            <h2 class="restarent-name"><%= res.getRestaurantName() %></h2>
        </div>
        <div class="details">
            <div class="data1 flex2 padd" style="color: black;">
                <p><%= res.getCuisineType() %></p>
                <p><i class="fa-solid fa-star"></i><%= res.getRatings() %></p>
            </div>
            <div class="data2 flex2 padd" style="color: black;">
                <p>Bangalore</p>
                <p class="<%= res.getIsActive() ? "active" : "inactive" %>"><%= res.getIsActive() ? "Open" : "Closed" %></p>
            </div>
        </div>
        <button style="background: rgb(205, 205, 205); border: 0; /* outline: 0; */ width: 83%; margin-left: 20px; padding: 4px 0; margin-top:20px; border-radius: 6px;">View Menu</button>
        
    </div>
    </a>
    <%
                }
            } else {
        %>
            <p>No restaurants available.</p>
        <%
            }
        %>
    <!-- Card End -->
</div>

</body>
</html>