# Spring Boot Project: Medical Appointment System

#Overview

This project implements a medical appointment system using Spring Boot, including entities for `Doctor` and `Patient`, repositories, services, controllers, validations, and H2 database configuration.

#Technologies Used:

- Spring Boot: Framework for creating Java applications.
- Spring Data JPA: Simplifies data access using Hibernate.
- H2 Database: In-memory database for development.
- Spring Web: RESTful web services.
- Postman: API testing tool.

## Project Structure


com.xcelore.assignment
│
├── controller
│   ├── DoctorController.java
│   └── PatientController.java
│
├── entity
│   ├── Doctor.java
│   └── Patient.java
│
├── repository
│   ├── DoctorRepository.java
│   └── PatientRepository.java
│
├── service
│   ├── DoctorService.java
│   └── PatientService.java
│
├── Application.java
└── application.properties


# Endpoints:
  - `/doctors`: CRUD operations for doctors.
  - `/patients`: CRUD operations for patients.

  # Testing:
  - Use Postman to test APIs.
  - Ensure functionality for adding, retrieving, and deleting doctors and patients.

## Database Configuration
properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=root
spring.datasource.password=root
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

