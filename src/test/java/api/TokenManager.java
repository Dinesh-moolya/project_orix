package api;

import api.applicationApi.IntanglesApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Login;
import utilities.CredsLoader;

public class TokenManager {

    private static String token;

    public static String getToken() {
        if (token == null) {
            CredsLoader credsLoader = new CredsLoader();
            Login loginPayload = new Login(credsLoader.getProperty("intangles_login_username"),
                    credsLoader.getProperty("intangles_login_password"));
            Response response = IntanglesApi.login(loginPayload);
            System.out.println(response.getBody().asString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("ABORT!!! Login failed");
            }

            JsonPath jp = new JsonPath(response.getBody().asString());
            String token = jp.getString("token");
            System.out.println(token);
            return token;
        }
        return token;
    }
}
