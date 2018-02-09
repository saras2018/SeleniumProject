import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class sampleForFrame  {
	@Test
	public void SampleForFrame(){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		driver.switchTo().frame(driver.findElementById("iframeResult"));
		driver.findElementByXPath("//button[text()[contains(.,'Try it')]]").click();
		driver.switchTo().alert().sendKeys("Saras");
		driver.switchTo().alert().accept();
		
	}
	

}
