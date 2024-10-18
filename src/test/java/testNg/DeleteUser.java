package testNg;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given; // Static import for given()

public class DeleteUser {

    // Existing method to delete by user ID
    public Response deleteUserById(int userId) {
        return given()
                .header("Authorization", AuthManager.getBasicAuthHeader())
                .when()
                .delete("/deleteuser/" + userId)
                .then()
                .extract()
                .response();
    }

    // New method to delete by first name
    public Response deleteUserByFirstName(String firstName) {
        return given()
                .header("Authorization", AuthManager.getBasicAuthHeader())
                .when()
                .delete("/deleteuser/username/" + firstName)
                .then()
                .extract()
                .response();
    }
}
