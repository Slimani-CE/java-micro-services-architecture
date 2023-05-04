# Java micro-services architecture


## Overview
This project is a Java Spring Boot application that demonstrates the usage of various web service technologies such as REST, SOAP, GraphQL, and gRPC. The application will be built as a microservice using JPA for data persistence and H2 as an in-memory database. It will expose a variety of APIs for managing user accounts and demonstrate how to use these web service technologies in a single application. The project will also involve generating and testing Swagger documentation, utilizing Spring Data Rest and projections, creating DTOs and Mappers, and implementing a Service layer for the microservice. Finally, a GraphQL Web service will be created to showcase the usage of GraphQL in a microservice architecture.

## Dependencies:

| Dependency                 | Description                                                                                                                                                |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Spring Boot Web            | Framework for building web applications with Spring Boot.                                                                                                  |
| Spring Data JPA            | Interface for working with relational databases using Java Persistence API (JPA).                                                                          |
| Spring Boot DevTools      | Provides fast application restarts, LiveReload, and configurations for enhanced development experience. (See how to configure it [here](#dev-tools-config)) |
| H2 Database                | Lightweight, in-memory database for testing and development.                                                                                               |
| Lombok                     | Library that helps to reduce boilerplate code in Java.                                                                                                     |
| Spring Data Rest           | Quick and easy way to create RESTful web services based on Spring Data repositories.                                                                       |
| Spring for GraphQL      | Build GraphQL applications with Spring for GraphQL and GraphQL Java.                                                                                       |

## REST API test with Postman
![Test REST API with Postman](assets/postmantest1.png)


### <h3 id = "dev-tools-config">DevTools Configuration in IntelliJ</h3>
1. Go to *'Settings/Build, Execution, Deployment/Compiler'* and check *'Build Project Automatically'*
![devtools step 1](assets/devtools%20step%201.png)
2. Go to *'Settings/Advanced settings'* and check *'Allow auto-make to start even if developed application is currently running '*
![devtools step 2](assets/devtools%20step%202.png)
