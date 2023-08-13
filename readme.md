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

## Contributing

Contributions are welcome! Feel free to submit pull requests or issues for any improvements or concerns you encounter.

## License

This project is licensed under the MIT License. For more details, please refer to the [LICENSE](LICENSE) file.