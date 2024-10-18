package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateUserTests {

    @DataProvider(name = "userDataFromCSV")
    public Object[][] userDataFromCSV() {
        String line;
        String csvFile = "src/test/resources/UserAccessDataCSVFile.csv"; // Updated path to your CSV file
        String csvSplitBy = ",";
        List<Object[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][]);
    }

    @Test(dataProvider = "userDataFromCSV")
    public void givenValidUserDetails_whenAddNewUser_thenUserIsCreated(String firstName, String lastName, String contactNumber, String emailId, String plotNumber, String street, String state, String country, String zipCode) {
        CreateUser createUser = new CreateUser();
        
        Response response = createUser.addNewUser(firstName, lastName, contactNumber, emailId, plotNumber, street, state, country, zipCode);
        
        if (response.getStatusCode() == 201) {
            System.out.println("User created successfully with ID: " + response.jsonPath().getInt("user_id"));
        } else {
            System.err.println("Failed to create user: " + response.getStatusLine());
        }
    }
}
