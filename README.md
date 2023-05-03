# Java micro-services architecture


## Overview
Thi project is a Java Spring Boot application that demonstrates the usage of various web service technologies such as REST, SOAP, GraphQL, and gRPC. The application will be built as a microservice using JPA for data persistence and H2 as an in-memory database. It will expose a variety of APIs for managing user accounts and demonstrate how to use these web service technologies in a single application. The project will also involve generating and testing Swagger documentation, utilizing Spring Data Rest and projections, creating DTOs and Mappers, and implementing a Service layer for the microservice. Finally, a GraphQL Web service will be created to showcase the usage of GraphQL in a microservice architecture.

## Dependencies:

| Dependency                 | Description                                                                                                                                                              |
|----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Spring Boot Web            | Framework for building web applications with Spring Boot.                                                                                                                |
| Spring Data JPA            | Interface for working with relational databases using Java Persistence API (JPA).                                                                                        |
| Spring Boot DevTools      | Provides fast application restarts, LiveReload, and configurations for enhanced development experience. (See how to configure it <a href = "#DevTools Configuration">here</a>) |
| H2 Database                | Lightweight, in-memory database for testing and development.                                                                                                             |
| Lombok                     | Library that helps to reduce boilerplate code in Java.                                                                                                                   |
| Spring Data Rest           | Quick and easy way to create RESTful web services based on Spring Data repositories.                                                                                     |
| Spring for GraphQL      | Build GraphQL applications with Spring for GraphQL and GraphQL Java.                                                                                                     |




### [!test]DevTools Configuration
1. Go to *'Settings/Build, Execution, Deployment/Compiler'* and check *'Build Project Automatically'*
2. Go to *'Settings/Advanced settings'* and check *'Allow auto-make to start even if developed application is currently running '*