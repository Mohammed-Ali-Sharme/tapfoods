# Food Delivery Website

## Overview
A dynamic food delivery website built using **Java**, **JSP**, **Servlets**, **HTML**, **CSS**, **JDBC**, and **SQL**. It includes features for user authentication, menu management, cart operations, and admin controls.

## Features
- User login and registration.
- Browse and filter food items.
- Add to cart and place orders.
- Admin panel for managing menu and orders.
- Responsive design with HTML and CSS.

## Technologies Used
- **Frontend:** HTML, CSS
- **Backend:** Java, JSP, Servlets
- **Database:** MySQL with JDBC

## Project Architecture
The project follows the **MVC (Model-View-Controller)** design pattern:

1. **Model:**
   - Represents the data and business logic of the application.
   - Includes classes to interact with the database (e.g., DAO classes) and data models (e.g., `Cart`, `CartItem`).

2. **View:**
   - Responsible for the user interface.
   - Uses JSP pages to render dynamic content (e.g., menu display, cart summary) and HTML/CSS for styling.

3. **Controller:**
   - Manages the flow between the model and view.
   - Includes Servlets to handle user requests (e.g., login, add to cart) and send responses.

### Workflow:
- **User Interaction:** A user performs an action (e.g., clicks "Add to Cart"), which triggers an HTTP request.
- **Controller Processing:** The servlet processes the request, interacts with the model to fetch or update data, and determines the appropriate view.
- **View Rendering:** The view (JSP) displays the updated data to the user.

## Setup
1. Set up the MySQL database and import the provided `food_delivery.sql` file.
2. Configure the database credentials in the project code.
3. Deploy the project on Apache Tomcat and run it.

## Usage
1. Register or log in.
2. Browse food items and add to the cart.
3. Place an order.
4. Admins can manage the menu and orders.

## License
Licensed under the MIT License.
