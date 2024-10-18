package testNg;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UpdateUser {
    public UpdateUser() {
        new AuthManager();
    }

    // Method to update user details
    public Response updateUser(int userId, String firstName, String lastName, 
                               String contactNumber, String emailId, 
                               String plotNumber, String street, 
                               String state, String country, String zipCode) {
        
        // Create the request body
        String requestBody = UserPayloads.updateUser(firstName, lastName, contactNumber, 
                emailId, plotNumber, street, state, country, zipCode);

        // Send the PUT request
        return given()
                .header("Authorization", AuthManager.getBasicAuthHeader()) // Use the Basic Auth header
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("https://userserviceapp-f5a54828541b.herokuapp.com/uap/updateuser/" + userId);
    }
}
