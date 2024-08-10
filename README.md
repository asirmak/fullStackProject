# Social Media Backend

This project is a social media backend built with Java Spring, utilizing a layered architecture. The project uses JDK 21 and incorporates JWT-based security features.

## Introduction

This project is designed to provide the backend services for a social media platform. It supports user authentication, post creation, comments, likes, and other social media functionalities.

## Architecture

The project follows a layered architecture, which includes:

1. **Presentation Layer (Controller)**: Handles HTTP requests and responses.
2. **Service Layer**: Contains the business logic.
3. **Data Access Layer (Repository)**: Interacts with the database.
4. **Model Layer**: Contains the entity classes and data transfer objects (DTOs).
5. **Security Layer**: Manages JWT-based authentication and authorization.

## Technologies Used

- **Java 21**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Spring Data JPA**
- **MySQL** (or any other relational database)
- **Maven** (for build and dependency management)

## Features

- User registration and authentication using JWT.
- Create, read, update, and delete posts.
- Comment on posts and like posts.
- Follow and unfollow other users.
- Secure endpoints using role-based access control.
- Token-based authentication for APIs.

### Prerequisites

- JDK 21
- Maven
- MySQL or another relational database
- IDE (Eclipse EE - Jun 2024)
