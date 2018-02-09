package week1.day1;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class EditLead extends SeMethods {

	@Test(dependsOnMethods={"week1.day1.BasicSelenium.createLead"})
	public void editLead() {
		
		SeMethods parent = new SeMethods();
		parent.startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		
		//Find user id field and enter valid user name
		parent.locateElement("id", "username");
		WebElement usrid = parent.locateElement("username");
		parent.type(usrid, "DemoSalesManager");
		
		//Find password field and enter valid password
		parent.locateElement("id", "password");
		WebElement pwd = parent.locateElement("password");
		parent.type(pwd, "crmsfa");
		
		
		//Find the Login button and click
		WebElement btn =parent.locateElement("class","decorativeSubmit");
		
		parent.click(btn);
		

	}

}
