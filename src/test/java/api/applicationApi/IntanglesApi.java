package api.applicationApi;

import api.RestResource;
import io.restassured.response.Response;
import pojo.Login;
import java.util.HashMap;

import static api.Route.LOCATION;
import static api.Route.LOGIN;
import static api.Route.VEHICLE_LIST;
import static api.TokenManager.getToken;

public class IntanglesApi {

    public static Response login(Login loginPayload) {
        return RestResource.post(LOGIN, loginPayload);
    }

    public static Response getVehicleList(String vehicleName) {
        HashMap<String, String> query = new HashMap<>();
        query.put("lastloc", "true");
        query.put("query", vehicleName);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Intangles-User-Token", getToken());

        return RestResource.get(VEHICLE_LIST, headers, query);
    }

    public static Response getAddress(String latLong) {
        HashMap<String, String> query = new HashMap<>();
        query.put("third_party", "true");
        query.put("lang", "en");

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Intangles-User-Token", getToken());

        return RestResource.get(LOCATION, headers, query, latLong);
    }

}
