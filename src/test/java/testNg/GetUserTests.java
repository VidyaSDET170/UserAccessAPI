package testNg;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTests {
    private final GetUser getUser = new GetUser();

    @Test
    public void givenValidAuth_whenGetAllUsers_thenStatusCodeIs200() {
        Response response = getUser.getAllUsers();
        
        // Validate response
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertNotNull(response.getBody(), "Response body should not be null");
    }

    @Test
    public void givenValidAuth_whenGetUserById_thenStatusCodeIs200() {

        int userId = 11253; 
        
        Response response = getUser.getUserById(userId);
        
        // Validate response
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertEquals(response.jsonPath().getInt("user_id"), userId, "User ID should match");
    }

}
