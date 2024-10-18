package testNg;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTests {

    @Test
    public void givenValidUserId_whenDeleteUser_thenUserIsDeletedSuccessfully() {
        int userId = GlobalData.userId;
        System.out.println("Using stored user_id for deletion: " + userId);

        DeleteUser deleteUser = new DeleteUser();
        Response responseById = deleteUser.deleteUserById(userId);

        Assert.assertEquals(responseById.statusCode(), 200);
        Assert.assertEquals(responseById.jsonPath().getString("status"), "Success");
        Assert.assertEquals(responseById.jsonPath().getString("message"), "User is deleted successfully");

        String firstName = "VidFirstName";
        Response responseByFirstName = deleteUser.deleteUserByFirstName(firstName);

        Assert.assertEquals(responseByFirstName.statusCode(), 200);
        Assert.assertEquals(responseByFirstName.jsonPath().getString("status"), "Success");
        Assert.assertEquals(responseByFirstName.jsonPath().getString("message"), "User is deleted successfully");
    }
}
