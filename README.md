# OnlineBookStore - Full Stack Microservices Based E-Commerce Platform

A full-stack e-commerce application built using Spring Boot with Microservices. The system provides core e-commerce functionalities including product browsing, user authentication, shopping cart, order management.

## 🚀 Features
### 👤 User Module

- User registration & login
- Profile management
- Add/remove products from cart
- Place and track orders

### 📦 Product Module

- Product listing filtering and search
- Product details page
- Admin can add/update/delete products

### 🛒 Cart & Orders

- Add multiple products to cart
- Update quantities or remove products
- Checkout with address
- Order history & tracking

### ⚙️ Backend

- Spring Boot Microservices Architecture
  - UserRegisterService
  - BookService
  - CartService
  - OrderService
  - AdminService
  - RatingService
  - AdminServer
  - ConfigServer
  - API Gateway (Spring Cloud Gateway)
  - Service Discovery (Eureka Server)
- Database: MySQL
- Communication: REST APIs

## 🔧 Installation & Setup

### 1️⃣ Clone the Repository
```
git clone https://github.com/heenadhanure/ec-onlinebookstore.git
cd ec-onlinebookstore
```

### 2️⃣ Backend Setup

- Import backend services into your IDE (STS / Eclipse / IntelliJ)
- Create ConfigServer repository specific for your project in your GitHub account. Configure MySQL in application.properties of ConfigServer Repository :
```
spring.datasource.url=jdbc:mysql://localhost:3306/estore_db
spring.datasource.username= your_username
spring.datasource.password= your_password
```
1) Run Eureka Discovery Server
2) Run Admin Server
3) Run Config Server
4) Run API Gateway
5) Run each service

- Test all the REST APIs in Postman or Insomnia 

## 📜 License
This project is licensed under the [MIT](https://github.com/heenadhanure/EC-OnlineBookStore/blob/a4be7beb8ba496cafa3a359959b90e8ba412b6e7/LICENSE) License.

## Contact
- Name : Dhanure Heena
- Email : heena.dhanure@gmail.com
- GitHub : heenadhanure
