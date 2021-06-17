package testAPIPackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import testFiles.Payload;
import testFiles.ReusableUtils;

public class DynamicJsonOps {
	
	@Test
	public void addBookLibraryAPI()
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		String strAddBookResponseJson = given().log().all().header("Content-Type","application/json")
		.body(Payload.AddBookAPI())
		.when().put("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).body("Msg",equalTo("successfully added"))
		.extract().response().asString();
			
		JsonPath objDynamicJsonjs = ReusableUtils.convertJsontoString(strAddBookResponseJson);
		String strBookIdgenerated = objDynamicJsonjs.getString("ID");
		System.out.println(strBookIdgenerated);
		 
	}

}
