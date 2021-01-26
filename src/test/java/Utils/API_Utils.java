package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.io.InputStream;

public class API_Utils {

    public static JsonPath rawDataToJson(String response) {
        JsonPath js1 = new JsonPath(response);
        return js1;
    }

    public static JsonPath rawResponseDataToJson(Response response) {
        JsonPath js = new JsonPath((File) response);
        return js;
    }
}
