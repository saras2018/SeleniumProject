package week1.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;;

public class BasicSelenium {
     @Test()
	public void createLead() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		
		int p=driver.getPageSource().length();
		//String str=driver.
		
		System.out.println(p);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		/*driver.findElementById
		driver.findElementById("createLeadForm_lastName").sendKeys("Jaikumar");
		Thread.sleep(5000);
		//driver.findElementByLinkText("Logout").click();
		//Thread.sleep(5000);*/
        driver.close();
		

	}

}
