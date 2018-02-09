package wdMethods;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;


public class ProjectMethods extends SeMethods {
	
	@Parameters({"url","uid","pwd"})
	@BeforeMethod
	
	public void leafTapsLogin(String url,String uid, String pwd) throws InterruptedException{
		
	startApp("chrome", url);
	
	//Find user id field and enter valid user name
	
	type(locateElement("id", "username"), uid);
	
	//Find password field and enter valid password
	
	type(locateElement("id", "password"), pwd);
	//Thread.sleep(2000);
	
	//Find the Login button and click
	
	
	click(locateElement("class","decorativeSubmit"));
	
	
	//Find the CRMSFA link and click 
	
    click(locateElement("link" , "CRM/SFA"));
	
  //Find the Leads button and click
  	click(locateElement("link", "Leads"));
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		@AfterMethod
	public void afterMethod()
	{
		System.out.println("This is imlemented after the Method");
		closeBrowser();
		
	}
	
	
		
	
	
	
	
}



