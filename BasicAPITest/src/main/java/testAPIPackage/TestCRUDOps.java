package testAPIPackage;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import testFiles.Payload;
import testFiles.ReusableUtils;

//import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
//import io.restassured.matcher.RestAssuredMatchers.*;
//import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class TestCRUDOps {

	public static void main(String[] args) {
		//1. Add a place on Map - Post Place API to
		System.out.println("******** POST Method / assert status code, body,header **********");
		//all input details - given block
		// resource and http method - when block
		//  validate the response - then block
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		//define the string to store the response
		
		String responsebody = given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		// fetch the body from different payload class
		.body(Payload.AddPlace())
		.when().post("maps/api/place/add/json")
		//verify the status code and validate one of the parameters from the response body
		//Assertion on JSON response - body , header
		.then().assertThat().log().all().statusCode(200).body("scope", equalTo("APP"))
		//when the methods are used after given() , they are treated as output
		.header("Server", "Apache/2.4.18 (Ubuntu)")
		//extract JSON response as string 
		.extract().response().asString();
		//Print the response body
		System.out.println(responsebody);
		
		//Parsing the JSON body Response using JsonPath class
		System.out.println("******** Extract Json Values of Place ID from POST Method Response *********");
		JsonPath js = ReusableUtils.convertJsontoString(responsebody);
		String Place_ID = js.getString("place_id");
		System.out.println(Place_ID);
		
		// 2. Update the place address - PUT place API
		// Integrating the API with common JSON Response values
		System.out.println("******** PUT Method / assert status code and updated address **********");
		String  newAddtoUpdate = "API Automation World Avenue 1A";
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+Place_ID+"\",\r\n"
				+ "\"address\":\""+newAddtoUpdate+" \",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//3. Get the place detail - GET API to validate the new address.
		System.out.println("******** GET Method / assert status code **********");
		String updatedAddressresponse ="";
		updatedAddressresponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id",Place_ID)		
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		//Extract the updated address from the Json
		System.out.println("******** Extract Json Values from GET Method Response *********");
		JsonPath addresstag = ReusableUtils.convertJsontoString(updatedAddressresponse);
		String address_jsontag = addresstag.getString("address");
		String latitude_jsontag = addresstag.getString("location.latitude");
		System.out.println("Address value in updated json :: "+address_jsontag);
		System.out.println("Latitude value in updated address json :: "+latitude_jsontag);
		
		// Cucumber JUnit - from scratch  and TestNG Framework while studying use
		Assert.assertEquals(address_jsontag.trim(),newAddtoUpdate.trim());
		
		
		
		
		
	}

}
