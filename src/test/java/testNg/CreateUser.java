package testNg;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class CreateUser {
    public CreateUser() {
        new AuthManager();
    }

    // Method to create a new user
    public Response addNewUser(String firstName, String lastName, String contactNumber,
                                String emailId, String plotNumber, String street,
                                String state, String country, String zipCode) {
        
        // Create the request body
        String requestBody = UserPayloads.createUser(firstName, lastName, contactNumber,
                emailId, plotNumber, street, state, country, zipCode);

        // Send the POST request
        return given()
                .header("Authorization", AuthManager.getBasicAuthHeader()) // Use the Basic Auth header
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://userserviceapp-f5a54828541b.herokuapp.com/uap/createusers");
    }
}
