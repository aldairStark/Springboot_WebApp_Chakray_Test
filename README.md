================================ User API - Technical Test ================================ 
Author: José Aldair Nava Correa  

REST API built with Spring Boot 3 and Java 17 for user management.  
Implements CRUD operations, filtering, sorting and authentication as required in the technical assessment.

---

1.-Technologies Used

- Java 17  
- Spring Boot 3.2.5  
- Maven 3.6  
- Docker  
- OpenAPI / Swagger  
- AES-256 password encryption  

---

2.- Project Description

This API manages users stored in an in-memory array as required in the technical test.

It supports:

- Create users  
- Update users  
- Delete users  
- Sort users  
- Filter users  
- Login authentication  
- Validations  
- Swagger documentation  
- Docker containerization  

---

 3.- Run Locally==========================

* Requirements

- Java 17  
- Maven 3.6+  

** Build the project============================

mvn clean package -DskipTests

** Run the application==========================

mvn spring-boot:run

Application runs at:

http://localhost:8080

---

4.- Run with Docker =============================

* Build Docker image ----------------------------

docker build -t user-api .

* Run container ---------------------------------

docker run -p 8080:8080 user-api

Application available at:

http://localhost:8080

---

5.- Swagger Documentation ==================================

Swagger UI available at:

http://localhost:8080/swagger-ui.html

---

6.- API Endpoints

* GET /users

Returns all users stored in memory.

---

** GET /users?sortedBy={attribute}

Returns users sorted by the specified attribute.

Allowed attributes:

- email  
- id  
- name  
- phone  
- tax_id  
- created_at  

Example:

/users?sortedBy=email

---

** GET /users?filter={attribute}+{operator}+{value}

Returns users filtered by attribute.

Supported operators:

- co → contains  
- sw → starts with  
- ew → ends with  
- eq → equals  

Examples:

/users?filter=name+co+user  
/users?filter=email+ew+mail.com  
/users?filter=phone+sw+555  
/users?filter=tax_id+eq+AARR990101XXX  

Filter parameter cannot be null or empty.

---

** POST /users

Creates a new user.

- Password is encrypted using AES-256.  
- created_at is automatically generated.  
- tax_id must be unique.  
- Password is removed from response body.  

---

** PATCH /users/{id}

Updates a user by UUID.

- UUID must be valid.  
- Only provided fields are updated.  

---

** DELETE /users/{id}

Deletes a user by UUID.

---

** POST /login

Authenticates a user.

- tax_id is used as username.  
- Password is validated against AES-256 encrypted value.  
- Returns authentication response if credentials are valid.  

---

7.- Validations Implemented

- tax_id:
  - Must follow RFC format  
  - Must be unique  

- Phone number:
  - Must contain 10 digits  
  - May include country code  
  - Validated format  

- Password:
  - Encrypted using AES-256  
  - Not returned in API responses  

- created_at:
  - Automatically generated  
  - Madagascar time zone  
  - Format: dd-MM-yyyy HH:mm  

- UUID:
  - Must follow valid UUID format  

---

8.- Unit Tests==============================

Unit tests validate:

- User creation  
- User update  
- User deletion  
- Filtering and sorting  
- Exception handling  

---

 Postman Collection

A Postman collection is included to test:

- CRUD operations  
- Sorting  
- Filtering  
- Login  

---

* Deliverables

This project includes:

- Source code  
- Dockerfile  
- README documentation  
- Swagger documentation  
- Unit tests  
- Postman collection  

---

* Notes

- Users are stored in-memory as required.  
- No database is used.  
- Application is fully containerized with Docker.  
- Built following clean architecture principles.  

---

* Final Status

All requirements from the technical test have been implemented, including optional extras such as:

- Docker  
- Swagger  
- Unit tests  
- Postman collection  