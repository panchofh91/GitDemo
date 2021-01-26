package API;

import TestData.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {

    public static void main(String[] args) {

        //Print Number of courses returned by API
        JsonPath js = new JsonPath(payload.costPrice());

        int count = js.getInt("courses.size()");
        System.out.println("This is the Number of Courses in the dashboard: " + count);

        //Print Purchase Amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("This is the Purchase Amount for the Courses in the dashboard: " + totalAmount);

        //Print Title of the first course
        String titleFirstCourse = js.getString("courses[0].title");
        System.out.println("This is the Title for the first Course in the dashboard: " + titleFirstCourse);

        System.out.println("==================Titles and Prices of all Courses=======================");

        //Print all course titles and their respective prices
        for (int i = 0; i < count; i++) {
            String coursesTitles = js.getString("courses[" + i + "].title");
            int coursesPrices = js.getInt("courses[" + i + "].price");
            System.out.println(coursesTitles + "\n" + coursesPrices);
        }

        //Print number of copies sold by RPA course
        for (int i = 0; i < count; i++) {
            String coursesTitles = js.getString("courses[" + i + "].title");
            if (coursesTitles.equalsIgnoreCase("RPA")) {
                int copiesSoldByRPA = js.getInt("courses[" + i + "].copies");
                System.out.println("This is the number of copies sold by RPA: " + copiesSoldByRPA);
                break;
            }
        }

    }
}
