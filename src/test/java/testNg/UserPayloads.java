package testNg;

public class UserPayloads {

    public static String createUser(String firstName, String lastName, String contactNumber, String emailId, 
                                      String plotNumber, String street, String state, String country, String zipCode) {
        return String.format("{ \"user_first_name\": \"%s\", \"user_last_name\": \"%s\", " +
                             "\"user_contact_number\": \"%s\", \"user_email_id\": \"%s\", " +
                             "\"userAddress\": { \"plotNumber\": \"%s\", \"street\": \"%s\", \"state\": \"%s\", " +
                             "\"country\": \"%s\", \"zipCode\": \"%s\" } }", 
                             firstName, lastName, contactNumber, emailId, plotNumber, street, state, country, zipCode);
    }

    public static String updateUser(String firstName, String lastName, String contactNumber, String emailId, 
                                      String plotNumber, String street, String state, String country, String zipCode) {
        return String.format("{ \"user_first_name\": \"%s\", \"user_last_name\": \"%s\", " +
                             "\"user_contact_number\": \"%s\", \"user_email_id\": \"%s\", " +
                             "\"userAddress\": { \"plotNumber\": \"%s\", \"street\": \"%s\", \"state\": \"%s\", " +
                             "\"country\": \"%s\", \"zipCode\": \"%s\" } }", 
                             firstName, lastName, contactNumber, emailId, plotNumber, street, state, country, zipCode);
    }
}
