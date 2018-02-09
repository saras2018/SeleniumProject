package week1.day1;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		driver.findElementById("createLeadForm_firstName").sendKeys("Saraswathi");
		driver.findElementById("createLeadForm_lastName").sendKeys("Jaikumar");
		
		
		WebElement dd1 = driver.findElementById("createLeadForm_dataSourceId");
		Select dropdown = new Select(dd1);
		List<WebElement> options = dropdown.getOptions();
		dropdown.selectByIndex(options.size()-1);
		
		WebElement dd2 = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropdown2 = new Select(dd2);
		//List<WebElement> options2 = dropdown2.getOptions();
		dropdown2.selectByVisibleText("Road and Track");
		
		WebElement dd3 = driver.findElementById("createLeadForm_industryEnumId");
		Select dropdown3 = new Select(dd3);
		//List<WebElement> options3 = dropdown3.getOptions();
		dropdown3.selectByValue("IND_INSURANCE");
		
		//Thread.sleep(5000);"
		//driver.findElementByLinkText("Logout").click();
		//Thread.sleep(5000);
        //driver.close();
		

	}

}
