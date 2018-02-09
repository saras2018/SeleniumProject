package wdMethods;
//import java.util.ArrayList;
//import java.util.List;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.Point;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;;

public class MergeLead extends ProjectMethods {
  
	@Test(groups="Leads",dependsOnGroups="mainLeads")
	
	public void mergeLead() throws InterruptedException {
		
		//Click on the Merge Lead link
		click(locateElement("link", "Merge Leads"));
		
		//Click on the image next to FindLeads text box
		click(locateElement("xpath", "(//img[@alt='Lookup'])[1]"));
		
		//Switch control to the current window
		switchToWindow(1);
		
		//Verify the title of the switched window
		verifyTitle("Find Leads");
		
		//Put the 1st user id from the list to FromLeads 
		String str1 = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"));
		type(locateElement("xpath","//input[@name='id']"),str1);
		
		//Click the Find Leads button
		click(locateElement("xpath", "//button[contains(text(),'Find Leads')]"));
		Thread.sleep(3000);
		
		//Select the first record from the list and click
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"));
		
		//Switch back to the main window
		switchToWindow(0);
		
		//Click on the image next to To Leads text box
		click(locateElement("xpath", "(//img[@alt='Lookup'])[2]"));
		
		//Switch to the current window
		switchToWindow(1);
		Thread.sleep(1000);
		
		//Put the 1st user id from the list to ToLeads
		String str2 = getText(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[6]"));
		type(locateElement("xpath","//input[@name='id']"),str2);
		
		//Click the Find Leads button
		click(locateElement("xpath", "//button[contains(text(),'Find Leads')]"));
		Thread.sleep(3000);
		
		//Click on the first record from the list
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		//Switch back to the main window
		switchToWindow(0);
		
		//Click on the Merge button
		click(locateElement("xpath", "//a[@class='buttonDangerous']"));
		
		//Accept the alert
		acceptAlert();
		
		//Click on the FindLeads
		click(locateElement("xpath", "//a[@href='/crmsfa/control/findLeads']"));
		
		//Check to ensure the Leads got merged
		//Find the record in the FindLeads
		type(locateElement("xpath", "//input[@name='id']"), str1);
		
		//Click on the Find Leads button
		click(locateElement("xpath", "//button[contains(text(),'Find Leads')]"));
		
		//Get the displayed message
		System.out.println(getText(locateElement("xpath", "//div[text()='No records to display']")));
		
		//Close the browser
		closeBrowser();
		
	}

}
