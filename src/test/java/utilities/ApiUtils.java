package utilities;

import api.TokenManager;
import api.applicationApi.IntanglesApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.Address;
import pojo.Vehicle;

public class ApiUtils {

    private static String vehicleAddress;

    public static String getAddress(String vehicle) throws JsonProcessingException {
        if (vehicleAddress != null) {
            return vehicleAddress;
        } else {
            return getVehicleCurrentAddressJsonPath(vehicle);
        }
    }

    public static String getVehicleCurrentAddress(String vehicle) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TokenManager.getToken();
        vehicle = vehicle.replace(" ", "");

        Response res = IntanglesApi.getVehicleList(vehicle);
        Vehicle obj = objectMapper.readValue(res.getBody().asString(), Vehicle.class);
        String lat = obj.getV().get(0).getLastState().getLoc().getLat();
        String lng = obj.getV().get(0).getLastState().getLoc().getLng();
        String latLong = lat + "," + lng;

        Response response = IntanglesApi.getAddress(latLong);
        Address obj2 = objectMapper.readValue(response.getBody().asString(), Address.class);
        vehicleAddress = obj2.getObj().getFormattedAddress();

        return vehicleAddress;
    }

    public static String getVehicleCurrentAddressJsonPath(String vehicle) throws JsonProcessingException {
        TokenManager.getToken();

        vehicle = vehicle.replace(" ", "");
        Response res = IntanglesApi.getVehicleList(vehicle);
        JsonPath jp = new JsonPath(res.getBody().asString());
        String lat = jp.getString("v[0].last_state.loc.lat");
        String lng = jp.getString("v[0].last_state.loc.lng");
        String latLong = lat + "," + lng;

        Response response = IntanglesApi.getAddress(latLong);
        jp = new JsonPath(response.getBody().asString());
        vehicleAddress = jp.getString("obj.formattedAddress");

        return vehicleAddress;
    }

}
