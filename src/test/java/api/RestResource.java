package api;

import io.restassured.response.Response;

import java.util.HashMap;

import static api.SpecBuilder.getRequestSpec;
import static api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, Object login) {
        return given(getRequestSpec()).body(login).when().post(path).then().spec(getResponseSpec()).extract()
                .response();
    }

    public static Response get(String path, HashMap<String, String> headers, HashMap<String, String> queryParams) {
        return given(getRequestSpec()).queryParams(queryParams).headers(headers).when().get(path).then()
                .spec(getResponseSpec()).extract().response();
    }

    public static Response get(String path, HashMap<String, String> headers, HashMap<String, String> queryParams,
            String pathParam) {
        return given(getRequestSpec()).queryParams(queryParams).headers(headers).when().get(path + pathParam).then()
                .spec(getResponseSpec()).extract().response();
    }

}
