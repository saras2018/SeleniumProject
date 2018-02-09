package utils;

import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {

	public ExtentReports report;
	public ExtentTest test;
	
	
	@BeforeSuite
	public void startReport(){
		
		//Strat the reporting 
		 report = new ExtentReports("./reports/result.html");
	}
	
	@BeforeMethod
	public void startTest(String testcaseNum, String desc,String category,String author){
		
		//Specifies the test cases and its description
		test = report.startTest(testcaseNum, desc);
		
		//Specify the category of the test cases and its author
		test.assignCategory(category);
		test.assignAuthor(author);

	}
	
	public abstract long takeSnap();
	
	public void reportStep(String desc,String status){
		
		//getting the snap number returned by the takeSnap method from SeMethods
		long snapNum = takeSnap();
		
		//Append the description with the corresponding image
		desc = desc+test.addScreenCapture("../reports/"+snapNum+".jpg");
		
		if (status.equalsIgnoreCase("PASS")) {
			test.log(LogStatus.PASS, desc);
		}else if (status.equalsIgnoreCase("FAIL"))
		{
			test.log(LogStatus.FAIL, desc);
		}else if (status.equalsIgnoreCase("WARNING"))
		{
			test.log(LogStatus.WARNING, desc);
		}
				
		

	}
	
	
	
	@AfterMethod
	public void endTest()
	{
		report.endTest(test);
	}
	
	@AfterSuite
	public void endReport()
	{
		report.flush();
	}
	
}
