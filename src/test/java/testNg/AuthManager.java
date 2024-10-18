package testNg;

import java.util.Base64;

public class AuthManager {

    private static final String USERNAME = "Numpy@gmail.com";
    private static final String PASSWORD = "userapi@october";

    public static String getBasicAuthHeader() {
        String credentials = USERNAME + ":" + PASSWORD;
        return "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
    }
}
