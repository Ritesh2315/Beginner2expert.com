package testAPIPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import testFiles.Payload;
import testFiles.ReusableUtils;

public class SumValidationExercise {

	@Test
	public void sumOfCoursesExercise()
	{
		JsonPath jsObj = ReusableUtils.convertJsontoString(Payload.CoursePriceJSON());
		int totpurchAmttemp =0;
		int countofCourses = jsObj.getInt("courses.size()");
		int TotalCoursePurchaseAmt = jsObj.get("dashboard.purchaseAmount");
		for(int jsonIterator =0;jsonIterator<countofCourses;jsonIterator++)
		{
			
			int priceofcoursetemp =  jsObj.get("courses["+jsonIterator+"].price");
			int noofcopiestemp =  jsObj.get("courses["+jsonIterator+"].copies");
			
			int totamountforacourse = priceofcoursetemp*noofcopiestemp;
			//System.out.println("test"+totamountforacourse);
			totpurchAmttemp = totpurchAmttemp +totamountforacourse;
			//System.out.println("total"+totpurchAmttemp);
			
		}
		System.out.println("total price ::"+totpurchAmttemp);
		Assert.assertEquals(totpurchAmttemp, TotalCoursePurchaseAmt);
	}
	
}
