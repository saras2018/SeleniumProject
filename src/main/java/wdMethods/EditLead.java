package wdMethods;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditLead extends ProjectMethods {
	
	@Test(dataProvider="inpEL"/*,groups="Leads",dependsOnGroups={"mainLeads"})*/)
	
	public void editLead(String fname,String comp,String vericomp) throws InterruptedException{
		
		//Find the find leads link and click
		click(locateElement("xpath","//a[@href='/crmsfa/control/findLeads']"));
		
		//Enter the first name 
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"),fname);
		
		//Click find leads button
		click(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(2000);
		
		//Click on the first resulting lead
		click(locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)"));
		
		//Verify the title of the page
		verifyTitle("View Lead");
		
		//Click edit button
		click(locateElement("link","Edit"));
		
		//Edit the company name
		type(locateElement("id", "updateLeadForm_companyName"),comp);
		
		//Click on the Update button
		click(locateElement("xpath", "//input[@value='Update']"));
		
		//Verify the updated company name
		verifyPartialText(locateElement("id", "viewLead_companyName_sp"), vericomp);
		
		//Close browser
		//closeBrowser();
		
		
		
	}
	@DataProvider(name="inpEL")
	public Object[][] dataset() throws IOException
	{
		/*Object[][] obj = new Object[2][3];
		obj[0][0] = "Saraswathi";
		obj[0][1]="Wipro";
		obj[0][2]="Wipro";
		
		obj[1][0] = "XYZ";
		obj[1][1]="AAA";
		obj[1][2]="CC";
		
		return obj;*/
		
		ReadFromExcel read = new ReadFromExcel();
		return read.excel("DataForEditLead");
		
	}
	
	
	

}
