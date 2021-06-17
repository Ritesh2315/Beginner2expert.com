package testAPIPackage;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import testFiles.Payload;
import testFiles.ReusableUtils;

public class ComplexJSONParsingExercise {

	public static void main(String[] args) {
		//JsonPath complexjsObj = new JsonPath(AddPlacePayload.CoursePriceJSON());
		JsonPath complexjsObj = ReusableUtils.convertJsontoString(Payload.CoursePriceJSON());
		int jsonIterator;
		//1. Print No of courses returned by API
		int countofCourses = complexjsObj.getInt("courses.size()");
		System.out.println("No of courses returned by API :: "+ countofCourses);
		//2.Print Purchase Amount
		int TotalCoursePurchaseAmt = complexjsObj.get("dashboard.purchaseAmount");
		System.out.println("Purchase Amount :: "+TotalCoursePurchaseAmt);
		//3. Print Title of the first course
		//4. Print All course titles and their respective Prices
		String titleOffirstCourse = complexjsObj.getString("courses[0].title");
		int priceOffirstCourse = complexjsObj.get("courses[0].price");
		int noOfCopiesSoldFirstCourse = complexjsObj.get("courses[0].copies");
		System.out.println("Title of first course :: "+titleOffirstCourse);		
		System.out.println("Price of first course :: "+priceOffirstCourse);		
		System.out.println("No of copies sold for first course :: "+noOfCopiesSoldFirstCourse);
		
		String titleOfSecondCourse = complexjsObj.getString("courses[1].title");
		int priceOfSecondCourse = complexjsObj.get("courses[1].price");
		int noOfCopiesSoldSecondCourse = complexjsObj.get("courses[1].copies");
		System.out.println("Title of second course :: "+titleOfSecondCourse);
		System.out.println("Price of second course :: "+priceOfSecondCourse);
		System.out.println("No of copies sold for second course :: "+noOfCopiesSoldSecondCourse);
		
		String titleOfThirdCourse = complexjsObj.getString("courses[2].title");
		int priceOfThirdCourse = complexjsObj.get("courses[2].price");
		int noOfCopiesSoldThirdCourse = complexjsObj.get("courses[2].copies");
		System.out.println("Title of third course :: "+titleOfThirdCourse);
		System.out.println("Price of third course :: "+priceOfThirdCourse);
		System.out.println("No of copies sold for third course :: "+noOfCopiesSoldThirdCourse);
		
		//5. Print no of copies sold by RPA Course
		
		for(jsonIterator =0;jsonIterator<countofCourses;jsonIterator++)
		{
			String tempCourseTitle = complexjsObj.get("courses["+jsonIterator+"].title");
			//System.out.println(tempCourseTitle);
			if (tempCourseTitle.toLowerCase().trim().equals("rpa"))
			{
				int noofexpectedcopiesofRPA = complexjsObj.get("courses["+jsonIterator+"].copies");
				System.out.println("No of copies of RPA sold ::" +noofexpectedcopiesofRPA);
				break;
			}
		}
		

		//6. Verify if Sum of all Course prices matches with Purchase Amount
		int totpurchAmttemp =0;
		for(jsonIterator =0;jsonIterator<countofCourses;jsonIterator++)
		{
			
			int priceofcoursetemp =  complexjsObj.get("courses["+jsonIterator+"].price");
			int noofcopiestemp =  complexjsObj.get("courses["+jsonIterator+"].copies");
			
			int totamountforacourse = priceofcoursetemp*noofcopiestemp;
			//System.out.println("test"+totamountforacourse);
			totpurchAmttemp = totpurchAmttemp +totamountforacourse;
			//System.out.println("total"+totpurchAmttemp);
			
		}
		Assert.assertEquals(totpurchAmttemp, TotalCoursePurchaseAmt);

	}

}
