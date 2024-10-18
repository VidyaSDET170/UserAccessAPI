package testNg;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUserTests {
    
    @Test
    public void updateUserTest() {
        int userId = 11253; 

        UpdateUser updateUser = new UpdateUser();
        
        Response response = updateUser.updateUser(userId, "VidFirstName", "UpdateCheckLastName", 
                "2354353622", "UpdateCheckEmail@gmail.com", 
                "12-bc", "New Street", 
                "FL", "USA", "123123");
        
        Assert.assertEquals(response.getStatusCode(), 200, "User update failed!");
    }
}
