# 50c719f9-2490-464a-8348-2eda7cd535e5
https://sonarcloud.io/summary/overall?id=examly-test_50c719f9-2490-464a-8348-2eda7cd535e5

# Updating Cross-Origin URLs for React and Spring Boot Applications

To ensure smooth communication between your React frontend and Spring Boot backend, follow these steps to update the Cross-Origin URLs:

## Update Spring Boot Port URL in React

1. Open the React application codebase.
2. Navigate to `reactapp/src/utils/api.js`.
3. Find line number 3 and update the `BASE_URL` constant with the Spring Boot port URL.

Example:
javascript
const BASE_URL = "https://8080-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io"; // Replace this with your Spring Boot port URL


## Update React Port URL in Spring Boot

1. Open the Spring Boot application codebase.
2. Go to `springapp/src/main/java/com/example/springapp/auth` and open `AuthenticationController.java`.
3. Similarly, navigate to `springapp/src/main/java/com/example/springapp/controller` and open the following classes:
   - `BookingController.java`
   - `CabController.java`
   - `CustomerController.java`
   - `FlightController.java`
   - `HotelController.java`

4. In each of the above controller classes, locate the `@CrossOrigin` annotation and update the URL with the React application's port URL.

Example:
java
@CrossOrigin("https://8081-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io") // Replace this with your React application port URL
@RestController
@RequestMapping("/api")
public class CommunicationController {
   // Controller code here
}


Additionally, in `springapp/src/main/java/com/example/springapp/SpringappApplication.java`, go to line 23 where you will find `.allowedOrigins("https://8081-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io")`. Update this URL with your React application's port URL.

Note:
- Replace `https://8080-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io` with your actual Spring Boot application's port URL.
- Replace `https://8081-feabcedadbfcacafaeedeacdfdaeaeaadbdbabf.project.examly.io` with your actual React application's port URL.

By following these steps, you will enable Cross-Origin requests between your React frontend and Spring Boot backend applications, ensuring they work seamlessly together.