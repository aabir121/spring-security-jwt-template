# Spring Boot Security with JWT Template

This repository provides a comprehensive template for creating secure and modern Spring Boot applications, integrating the latest technologies. It showcases the seamless integration of Spring Security with JWT-based authentication and connects to a MySQL database to demonstrate user-based roles. The application illustrates stateless communication and role-based access control for different endpoints.

## Features

- **Java Development Kit (JDK) 17**: Utilizes the latest JDK version for enhanced compatibility and performance.
- **Spring Boot**: Leverages the Spring Boot framework, facilitating rapid development and streamlined configuration.
- **Spring Security**: Employs Spring Security to implement robust authentication and authorization mechanisms.
- **JSON Web Tokens (JWT)**: Demonstrates the utilization of JWT for secure and stateless communication between the client and server.
- **MySQL Database**: Illustrates seamless integration with a MySQL database to store user information and roles.
- **User and Admin Endpoints**: Provides example endpoints showcasing role-based access control for both users and administrators.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17
- Maven (for building and managing dependencies)
- MySQL Database (with appropriate credentials)

### Installation and Setup

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/your-username/spring-boot-security-jwt-template.git
   cd spring-boot-security-jwt-template
   ```

2. **Database Configuration**:

   - Open the `src/main/resources/application.properties` file and update the following properties with your MySQL database information:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/sp_sec
     spring.datasource.username=root
     spring.datasource.password=root
     ```

3. **JWT Configuration**:

   - In the same `application.properties` file, set your JWT secret key and token validity in minutes:

     ```properties
     jwt.tokenValidityMinutes=90
     ```

4. **Build and Run the Application**:

   - Build and run the application using Maven:

     ```bash
     ./mvnw spring-boot:run
     ```

### Accessing Endpoints

- **Home**: [http://localhost:8080/](http://localhost:8080/)
- **User Endpoint**: [http://localhost:8080/user](http://localhost:8080/user)
- **Admin Endpoint**: [http://localhost:8080/admin](http://localhost:8080/admin)

## User Roles and Seed Data

This template implements role-based access control with two primary roles:

- **User Role**: Users with the "USER" role can access the `/user` endpoint.
- **Admin Role**: Users with the "ADMIN" role can access the `/admin` endpoint.

### Seeding Data

By default, the application will attempt to seed some example data into the database when it starts. This includes sample users with associated roles. If you want to customize this data or disable automatic seeding, you can modify the `DataSeeder` class in the `aabir.example.securityjpa` package.

### Testing the Application

To test the functionality of the Spring Boot Security with JWT application, follow these steps:

1. **User Authentication**:

    - Access the `/authenticate` endpoint using a POST request with the following JSON body:

      ```json
      {
        "userName": "user",
        "password": "password"
      }
      ```

    - The response will include a JWT token. Copy this token for the next steps.

2. **Accessing User Endpoint**:

    - Make a GET request to the `/user` endpoint and include the JWT token in the `Authorization` header with the value `"Bearer <TOKEN>"`.

    - You should receive a response with the message: `Welcome, user!`

3. **Accessing Admin Endpoint**:

    - Make a GET request to the `/admin` endpoint using the same JWT token in the `Authorization` header.

    - You should receive a response with the message: `Welcome, admin!`

### Expected Behavior

- The `/user` endpoint is accessible only by users with the "USER" or "ADMIN" role.
- The `/admin` endpoint is accessible only by users with the "ADMIN" role.
- The `/authenticate` endpoint provides a JWT token upon successful user authentication.

### Expanding the Application

You can further expand the functionality of this Spring Boot application:

1. **Frontend Integration**: Develop a frontend interface to interact with the backend API and handle user authentication using the generated JWT token.

2. **User Registration**: Implement a user registration process, allowing new users to create accounts with appropriate roles.

3. **Custom Claims**: Extend the JWT payload with custom claims, such as user-specific information or additional permissions.

4. **Password Encryption**: Enhance security by integrating password encryption mechanisms, such as BCrypt, for user passwords.

5. **Token Refresh**: Implement a token refresh mechanism to handle token expiration and improve user experience.

6. **API Documentation**: Create comprehensive API documentation using tools like Swagger to help users understand available endpoints and their usage.

7. **Integration Tests**: Write integration tests to ensure the proper functioning of the application's security features.

Feel free to explore these expansion options and tailor the application to your specific requirements.

---

## Contributing

Contributions are welcome! Feel free to submit pull requests or issues for any improvements or concerns you encounter.

## License

This project is licensed under the MIT License. For more details, please refer to the [LICENSE](LICENSE) file.