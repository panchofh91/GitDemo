package TestData;

public class payload {

    public static String AddPlace1() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Son Goku\",\n" +
                "  \"phone_number\": \"(+1) 707 893 7777\",\n" +
                "  \"address\": \"77, Outskirts of city, Satan City\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String AddPlace(double lat, double lng) {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": " + lat + ",\n" +
                "    \"lng\": " + lng + "\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Son Goku\",\n" +
                "  \"phone_number\": \"(+1) 707 893 7777\",\n" +
                "  \"address\": \"77, Outskirts of city, Satan City\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String updateAddress() {
        return "{\n" +
                "\"place_id\":\"1321\",\n" +
                "\"address\":\"70 winter walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }

    public static String costPrice() {
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Apium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    public static String addBookInfo(String aisle, String isbn) {
        String payload = "{\n" +
                " \n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\" isbn \":\" "+ isbn + "\",\n" +
                "\" aisle \":\" " + aisle + "\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
        return payload;
    }

}
