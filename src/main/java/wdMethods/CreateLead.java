package wdMethods;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ProjectMethods  {
	
	@Test(dataProvider ="dataforCL"/*, groups="mainLeads"*/)
 
	public void createLead(String company,String fname , String lname ,String phone , String email ){
		
		
        //Find the Create Lead link and click
        
        click(locateElement("link", "Create Lead"));
        
        //Enter Company Name
       
        type(locateElement("id","createLeadForm_companyName" ), company);
        
        //Enter First Name
        
        type(locateElement("id","createLeadForm_firstName" ), fname);
        
        //Enter Last Name
        
        type(locateElement("id","createLeadForm_lastName" ), lname);
        
        //Enter Phone Number
        type(locateElement("id", "createLeadForm_primaryPhoneNumber"), phone);
        
        //Enter email address
        type(locateElement("id", "createLeadForm_primaryEmail"), email);
        
        //Find the drop down for Source and select using the text
                
        selectDropDownUsingText(locateElement("id", "createLeadForm_dataSourceId"),"Existing Customer");
        
        //Click on the image next to Parent Account
        
        click(locateElement("xpath","//input[@name='parentPartyId']/following-sibling::a"));
        
        //Switch to the opened window
        switchToWindow(1);
        
        
        //Select the record DemoAccount1 from the list
        WebElement fnd = locateElement("xpath", "//a[text()='DemoAccount1']");
        click(fnd);
        
        //Switch back to previous window
        switchToWindow(0);
        
        //Click on Create Lead 
        WebElement btn1 = locateElement("xpath", "//input[@class='smallSubmit']");
        click(btn1);
        
        //Close the browser
        //closeBrowser();
	}
	
	@DataProvider(name = "dataforCL")
	public Object[][] dataForCL() throws IOException 
	{/*
		Object[][] obj = new Object[3][3];
		obj[0][0] = "Wipro";
		obj[0][1]="Saraswathi";
		obj[0][2]="J";
		
		obj[1][0]="TCS";
		obj[1][1]="ABC";
		obj[1][2]="D";
		
		obj[2][0]="TestLeaf";
		obj[2][1]="XYZ";
		obj[2][2]="W";
		return obj;*/
		
		ReadFromExcel read = new ReadFromExcel();
		
		return read.excel("DataForCreateLead");
		
		
	}

}

