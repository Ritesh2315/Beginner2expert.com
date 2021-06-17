package testFiles;

import io.restassured.path.json.JsonPath;
public class ReusableUtils {
	
	public static JsonPath convertJsontoString(String responsebody)
	{
		JsonPath objJs = new JsonPath(responsebody);
		return objJs;
	}

}
