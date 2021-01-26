package API;

import Constants.APIConstants;
import TestData.payload;
import Utils.API_Utils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class basics {
    public static void main(String[] args) throws IOException {
        // validate if add place is working as expected
        //Add place -> Update Place with New Address -> Get Place to validate if New Address is present in response

        //give - all input details
        //when - Submit the API - Resource, http method
        //then - validate the response

        //Add place -> //

        //BASE URL //
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // this is the whole API request //
        String response =
                given().log().all()
                        .queryParam("key", "qaclick123") // this is the whole API request //
                        .header("Content-Type", "application/json")
                        .body(payload.AddPlace1())
                        .when()
                        .post(APIConstants.addResource)
                        .then().assertThat().statusCode(200)
                        .body("scope", equalTo("APP"))
                        .header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        // for parsing Json //
        System.out.println("This is the response from the API: -> " + response);
        JsonPath js = new JsonPath(response); // for parsing Json //
        String placeId = js.getString("place_id");

        System.out.println("This is the Place ID from the response: -> " + placeId + "\n");

        // Update Place with New Address -> //

        String newAddress = "Summer Walk, Africa";
        given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + newAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put(APIConstants.updateResource)
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));


        // Get Place to validate if New Address is present in response -> //

        String getPlaceResponse =
                given().log().all().queryParam("key", "qaclick123")
                        .queryParam("place_id", placeId)
                        .when().get(APIConstants.getResource)
                        .then().assertThat().log().all().statusCode(200)
                        .extract().response().asString();

        JsonPath js1 = API_Utils.rawDataToJson(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);

        Assert.assertEquals(actualAddress, newAddress);

        System.out.println("?????????????????????????????????????????????????????????????");

        //example how to get test data from a local .json file//
        //NEED TO CONVERT THE CONTENT IN THE FILE TO String-> convert of file can convert into Byte code-> Byte data to String
        //BASE URL //
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        // this is the whole API request //
        String response2 =
                given().log().all()
                        .queryParam("key", "qaclick123") // this is the whole API request //
                        .header("Content-Type", "application/json")
                        .body(new String(Files.readAllBytes(Paths.get("C://Users/fher9_000/Desktop/addPlace.json"))))
                        .when()
                        .post(APIConstants.addResource)
                        .then().assertThat().statusCode(200)
                        .body("scope", equalTo("APP"))
                        .header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        // for parsing Json //
        System.out.println("This is the response from the API: -> " + response2);
        JsonPath js2 = new JsonPath(response); // for parsing Json //
        String placeId2 = js2.getString("place_id");

        System.out.println("This is the Place ID from the response: -> " + placeId2 + "\n");
    }
}
