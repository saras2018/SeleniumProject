package learnExtentReports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class LearnExtentReport {

	@Test
	public void extentReport()
	{
		
		//Create an object for the extentreports class and specify the file name of the report
		ExtentReports report = new ExtentReports("./reports/result.html");
		
		//Create an opbject for extent test and specify the testcase number and a description of the test case
		ExtentTest test = report.startTest("TC001_CreateLead", "Create a new Lead in LeafTaps");
		
		//Assign a test category
		test.assignCategory("sanity");
		
		//Assign a test author
		test.assignAuthor("Saraswathi");
		
	
		long snapNum = takeSnap(); 
		//Log the test result along with the snap shot
		test.log(LogStatus.PASS, "Username entered successfully"+test.addScreenCapture("../snaps/"+snapNum+".jpg"));
		
		test.log(LogStatus.FAIL, "Login button could not be clicked "+test.addScreenCapture("../snaps/snap2.jpg"));
		
		report.endTest(test);
		report.flush();
		
		
		
	}

	public abstract long takeSnap() ;
	
}
