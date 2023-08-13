# Spring Boot Security with JWT Template

This template repository provides a solid foundation for building secure and modern Spring Boot applications using the latest technologies. It seamlessly integrates Spring Security with JWT-based authentication, connecting to a MySQL database to showcase user-based roles. The application demonstrates stateless communication and role-based access control for different endpoints.

## Features

- **Java Development Kit (JDK) 17**: Utilizes the latest version of JDK to ensure compatibility and performance enhancements.
- **Spring Boot**: Leverages the Spring Boot framework to facilitate rapid development and streamlined configuration.
- **Spring Security**: Employs Spring Security for robust authentication and authorization mechanisms.
- **JSON Web Tokens (JWT)**: Illustrates the use of JWT for secure and stateless communication between client and server.
- **MySQL Database**: Demonstrates seamless integration with a MySQL database to store user information and roles.
- **User and Admin Endpoints**: Provides example endpoints that highlight role-based access control for users and administrators.

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
      jwt.secret-key=my-secret
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

## User Roles

- **User Role**: Users with the "USER" role can access the `/user` endpoint.
- **Admin Role**: Users with the "ADMIN" role can access the `/admin` endpoint.

## Contributing

Contributions are welcomed! Feel free to submit pull requests or issues if you find any improvements or want to address any concerns.

## License

This project is licensed under the MIT License. For details, see the [LICENSE](LICENSE) file.