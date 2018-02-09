package wdMethods;

import org.testng.annotations.Test;

public class DeleteLead extends ProjectMethods {

	@Test(groups="Leads",dependsOnGroups={"mainLeads"})
	
	public void deleteLead() throws InterruptedException{
		
		//Find the find leads link and click
		click(locateElement("xpath","//a[@href='/crmsfa/control/findLeads']"));
		
		//Click on the Phone tab
		click(locateElement("xpath", "(//span[@class='x-tab-strip-inner'])[2]"));
		
		//Enter phone number
		type(locateElement("xpath", "//input[@name='phoneNumber']"),"12345");
		
		//Click find leads button
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(2000);
		
		
		//Click on the first resulting lead
		String str = getText(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]"));
		System.out.println(str);
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		
		
		//Click delete button
		click(locateElement("link","Delete"));
		
		//Click the find leads link 
		click(locateElement("xpath","//a[@href='/crmsfa/control/findLeads']"));
		
		//Enter the captured lead id to verify deletion
		type(locateElement("xpath", "//input[@name='id']"),str);
		
		//Click on the Find Leads button
		click(locateElement("xpath","//button[text()='Find Leads']"));
		
		//Get the displayed message
		System.out.println(getText(locateElement("xpath", "//div[text()='No records to display']")));
				
		//Close the browser
		closeBrowser();
		
		
		
	}
}
