package wdMethods;
//import java.util.ArrayList;
//import java.util.List;

import org.testng.annotations.Test;;

public class DuplicateLead extends ProjectMethods {
      
	@Test(groups="Leads",dependsOnGroups="mainLeads")
	
	public void duplicateLead()   {
		
		
		
		//Find the find leads link and click
		click(locateElement("xpath","//a[@href='/crmsfa/control/findLeads']"));
		
		//Click on the email tab
		click(locateElement("link","Email"));
		
		//Enter the email address
		type((locateElement("name","emailAddress")),"abc@gmail.com");
		
		//Click on the Find Leads button
		click(locateElement("link","Find Leads"));
		
		//Click on the first name of the returned record
		click(locateElement("xpath","//td[@class='x-grid3-hd x-grid3-cell x-grid3-td-firstName']"));
		
		//Store the first name in a string variable to use for comparison  
		String str = getText(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-firstName']"));
		//System.out.println(str);
		//Thread.sleep(2000);
		
		//Click on the first record from the list
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		
		//Click on the Duplicate Leads tab
		click(locateElement("link", "Duplicate Lead"));
		
		//Click on the Create Lead tab below
		click(locateElement("xpath", "//input[@class='smallSubmit']"));
		
		//Get the text and store in a string(str1) and compare str and str1
		String str1 = getText(locateElement("xpath", "//span[@id='viewLead_firstName_sp']"));
		if (str1.equals(str)){
			System.out.println("pass");
		}
		else
		{System.out.println("fail");
		}
		
		//Close the browser
		closeBrowser();
}
}