# microservice-hystrix-dashboard
Hystrix dashboard with microservices


Microservice with standalone hystrix bashboard based on Kennedy Oliveira version

This project is compoused of four maven modules: First of all launch mvn clean install

Eureka Server

start this module with mvn spring-boot:run Running on port 1111 After that you can see the eureka dashboard on http://localhost:1111

Car Microservice

start this module with mvn spring-boot:run Running on port 2222 After that you can test the microservi with the next url http://localhost:2222/car/3

Microservice Client

start this module with mvn spring-boot:run Running on port 8080 After that you can test the microservice with the next url http://localhost:8082/client-car/3

Microservice Admin Dashboard

start this module with mvn spring-boot:run Running on port 8080 After that you can test the dashboard of spring boot admin with the next url http://localhost:8080

Hystrix Dashboard
start the dashboard runnint the next url: http://localhost:7979/hystrix-dashboard

After that execute client-car to see the dashboard results.

