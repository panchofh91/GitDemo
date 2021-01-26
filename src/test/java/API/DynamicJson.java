package API;

import Constants.APIConstants;
import TestData.payload;
import Utils.API_Utils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test(dataProvider = "BooksData")
    public void addBook(double lat, double lng) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
//        RestAssured.baseURI = ConfigReader.readProperty("BaseURI");
        String resp = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.AddPlace(lat, lng))
                .when()
                .post(APIConstants.addResource)
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(resp);
        JsonPath js = API_Utils.rawDataToJson(resp);
        String responseID = js.getString("place_id");
        System.out.println(responseID);

    }

    @DataProvider(name = "BooksData")
    public Object[] getData() {
        //Array is a Collection of elements
        //multi dimensional Array is Collection of Arrays
        return new Object[][]{{11.0, 22.1}, {12.2, 23.3}, {13.4, 24.5}};
    }


}
