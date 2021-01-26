package API;

import TestData.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    JsonPath js = new JsonPath(payload.costPrice());
    int count = js.getInt("courses.size()");
    int expectedSumOfAllcourses = js.getInt("dashboard.purchaseAmount");

    //Verify Sum of all courses price matches with Purchased amount
    @Test
    public void sumOfCourses() {
        int actualSumOfAllcourses = 0;

        for (int i = 0; i < count; i++) {
            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int amount = price * copies;
            //System.out.println(amount);
            actualSumOfAllcourses += amount;
        }
        System.out.println(actualSumOfAllcourses);
        Assert.assertEquals(expectedSumOfAllcourses, actualSumOfAllcourses);
    }
}
