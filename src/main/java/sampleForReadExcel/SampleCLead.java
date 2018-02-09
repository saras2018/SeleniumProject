package sampleForReadExcel;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleCLead {

	@Test(dataProvider="dp")
	public void sampleCLead(String usrname,String pwd){
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		
		try {
			driver.findElementById("username").sendKeys(usrname);
			driver.findElementById("passwor").sendKeys(pwd);
			driver.findElementByClassName("decorativeSubmit").click();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Its my own error message");
			
		}
	}
	@DataProvider(name="dp")
	public Object[][] dp() throws IOException{
		SampleExcelClass sample = new SampleExcelClass();
		
		return sample.readExcel();
		
	}
		
	
}
