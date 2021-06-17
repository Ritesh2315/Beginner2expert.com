package testFiles;

public class Payload {
	
	public static String AddPlace()
	{
		String strAddPlace = "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Ritesh Kumar Practice API 2\",\r\n"
				+ "  \"phone_number\": \"(+91) 9999999999\",\r\n"
				+ "  \"address\": \"Test,Test1,Test123\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"https://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
		return strAddPlace;
	}
	public static String CoursePriceJSON()
	{
		String strCoursePriceJson = "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 1000,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"UFT\",\r\n"
				+ "      \"price\": 30,\r\n"
				+ "      \"copies\": 3\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		return strCoursePriceJson;
	}
	public static String AddBookAPI()
	{
		String strAddbookJson = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"hardhortra\",\r\n"
				+ "\"aisle\":\"2271\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return 	strAddbookJson;	
	}

}
