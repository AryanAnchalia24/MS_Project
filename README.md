# MS_Project
Overview
This E-Commerce website is built using a microservices architecture with two primary services: Product Service and Cart Service. The system enables users to manage products, create and manage carts, and ensure stock integrity during cart operations through service intercommunication.

Services
1. Product Service
The Product Service is responsible for managing the product catalog, including CRUD operations.

Features:
Add Product: Add a new product with details like name, description, price, and available stock.
Update Product: Update existing product details (e.g., price, description, or stock).
View Product: Retrieve the details of a product using its name or ID.
Delete Product: Remove a product from the catalog.
2. Cart Service
The Cart Service enables users to manage their shopping carts and add items by verifying product details from the Product Service.

Features:
Create Cart:
Create a cart with a unique ID and a user name.
Add Cart Item:
Add products to a cart by providing:
Cart ID.
Product name.
Quantity.

Intercommunication with Product Service:
Fetch product details by name.
Verify if the requested quantity is available in stock.

Stock Management:
If the stock is sufficient:
Deduct the ordered quantity from the available stock in the Product Service.
Add the item to the cart.
If the stock is insufficient:
The operation is rejected with an error message.
Architecture
Inter-Service Communication
The Cart Service communicates with the Product Service via REST APIs to fetch product details and update stock.
Workflow
1. Product Management
Use the Product Service to add, update, view, or delete products.
Each product includes:
Name
Description
Price
Stock
2. Cart Operations
Cart Creation:
Create a cart by providing a unique ID and the user’s name.
Adding Items to Cart:
Input the cart ID, product name, and quantity.
The Cart Service fetches product details from the Product Service.
The system checks if the requested quantity is available:
If available, the product is added to the cart and stock is decremented.
If not available, the user is notified.

Database Design

Product Service

Field	Type	Description
id	Integer	Unique product ID (Primary Key).
name	String	Name of the product.
description	Text	Description of the product.
price	Decimal	Price of the product.
stock	Integer	Available stock quantity.

Cart Service

Cart Table:

Field	Type	Description
id	Integer	Unique cart ID (Primary Key).
user_name	String	Name of the user.

Cart Items Table:

Field	Type	Description
id	Integer	Unique item ID (Primary Key).
cart_id	Integer	Foreign Key to the Cart Table.
product_name	String	Name of the product (fetched from Product Service).
quantity	Integer	Quantity of the product added.
price	Decimal	Price per unit of the product.
