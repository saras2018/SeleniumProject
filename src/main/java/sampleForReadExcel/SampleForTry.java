package sampleForReadExcel;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class SampleForTry extends SeMethods  {
	@Test
	public void getSample(){
		WebElement ele = sample("id","username");
		ele.sendKeys("DemoSalesManager");
	}
	
	public WebElement sample(String locator, String locValue)
	{
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps");
	
	 WebElement ele =  null; 
		
		try {
			switch(locator) {
			case "id":    driver.findElementById(locValue);
			
			case "class":  driver.findElementByClassName(locValue);
			
			case "link":  driver.findElementByLinkText(locValue);
			
			case "xpath" :  driver.findElementByXPath(locValue);
			
			case "name" :  driver.findElementByName(locValue);
			
			default: return null;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element could not be found");
			//throw new NoSuchElementException("Element "+locValue+" could not be found");
		}catch (WebDriverException e){
			System.err.println("Unknown error");
		}
		return ele;
	}

}
