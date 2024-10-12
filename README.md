# Online Bookstore Application

## Project Overview
The **Online Bookstore Application** is a full-stack web application designed to manage book inventories, handle user registration, authentication, and process orders. It allows users to browse and purchase books while administrators can manage book data. The backend is powered by **Spring Boot** and **Hibernate**, with **React.js** handling the frontend.

## Features
- **User Registration & Authentication**: Secure login and registration using **Spring Security** with role-based access.
- **Book Management**: Users can browse books, view details, and add books to their cart. Admins can manage the book inventory (CRUD operations).
- **Order Processing**: Users can place orders, and view order history.
- **MySQL Integration**: The application uses **MySQL** for storing user, book, and order data.
- **RESTful API**: Backend provides a REST API for the frontend to interact with.

## Technologies Used
- **Backend**:
  - Spring Boot
  - Hibernate (JPA)
  - Spring Security
  - MySQL
- **Frontend**:
  - React.js
  - HTML5 / CSS3 / JavaScript
- **Other**:
  - Maven (for dependency management)
  - Postman (for API testing)
  - BCryptPasswordEncoder (for password encryption)

## Setup Instructions

### Prerequisites
- **Java 11+**
- **MySQL** (Ensure MySQL is running and create a database for the application)
- **Node.js & npm** (For React frontend)

### Backend Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/coder1706/bookstore-web-app.git
    cd bookstore-web-app
    ```
2. Configure MySQL connection in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```
3. Run the Spring Boot application:
    ```bash
    ./mvnw spring-boot:run
    ```

### Frontend Setup
1. Navigate to the frontend directory:
    ```bash
    cd frontend
    ```
2. Install dependencies:
    ```bash
    npm install
    ```
3. Start the React app:
    ```bash
    npm start
    ```

## Endpoints

### Public
- `GET /home` - Fetch the home page
- `POST /user/register` - Register a new user.
- `POST /user/login` - Authenticate an existing user.

### Authenticated
- `GET /user/cart` - Fetch cart of the logged in user.
- `POST /user/orders` - Place an order.

### Admin
- `POST /admin/books` - Add a new book.
- `PUT /admin/books/{id}` - Update an existing book.
- `DELETE /admin/books/{id}` - Delete a book.

## Future Improvements
// Will be updated soon
