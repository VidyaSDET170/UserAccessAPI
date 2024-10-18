package testNg;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetUser {

    // Method to get all users
    public Response getAllUsers() {
        return given()
                .header("Authorization", AuthManager.getBasicAuthHeader())
                .when()
                .get("https://userserviceapp-f5a54828541b.herokuapp.com/uap/users")
                .then()
                .extract()
                .response();
    }

    // Method to get a user by ID
    public Response getUserById(int userId) {
        return given()
                .header("Authorization", AuthManager.getBasicAuthHeader())
                .when()
                .get("https://userserviceapp-f5a54828541b.herokuapp.com/uap/user/" + userId)
                .then()
                .extract()
                .response();
    }

    // Method to get a user by first name
    public Response getUserByFirstName(String firstName) {
        return given()
                .header("Authorization", AuthManager.getBasicAuthHeader())
                .when()
                .get("https://userserviceapp-f5a54828541b.herokuapp.com/uap/user/" + firstName) // Changed the URL here
                .then()
                .extract()
                .response();
    }
}
