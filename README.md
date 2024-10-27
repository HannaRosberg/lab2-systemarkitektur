# Lab 2 system architecture

1. **Clone the Repository**: 
https://github.com/HannaRosberg/lab2-systemarkitektur


2. **Open the Project in IntelliJ**


3. **Build the Project**: 
with command "mvn clean install"


4. **Start the wildfly server and deploy the war file.**


5. **Use a local server with the localhost:**
   http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/


6. **Run the server and open the explorer**


7. **Endpoints:**
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products?page=1&size=10
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products?page=2&size=10
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products/1
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products/categories/BOOKS
   

8. **Post a new product in postman, insomnina or similiar apps**
   POST http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products
  - Host: localhost:8080
  - Content-Type: application/json

- {
- "category": "PETS",
- "createdDate": "2024-09-30",
- "id": "13",
- "modifiedDate": "2024-09-30",
- "name": "Dog food",
 -"rating": 3
- }


9. **Update the browser with the page2 to see the updated product.**

# Lab 3 system architecture

**Open terminal**

1. **Pull the image from docker:**
```sh
   docker pull hannarosberg/lab2-systemarkitektur
   ```


2. **Run the container:**
```sh
   docker run -p 8080:8080 hannarosberg/lab2-systemarkitektur:latest
```

3. **Access the application:**
```sh
   http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT
```

4. **Endpoints:**
```sh
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products?page=1&size=10
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products?page=2&size=10
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products/1
   - http://localhost:8080/lab2-systemarkitektur-1.0-SNAPSHOT/api/products/categories/BOOKS
```