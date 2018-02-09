package week1.day1;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;;

public class irctcWindowHandlers {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.manage().window().maximize();
		
		driver.findElementByLinkText("Contact Us").click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> allWindows = new ArrayList<>();
		allWindows.addAll(windowHandles);
		String secondWindowHandle = allWindows.get(1);
		driver.switchTo().window(secondWindowHandle);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.close();
		String firstWindowHandle = allWindows.get(0);
		driver.switchTo().window(firstWindowHandle);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.findElementById("usernameId").sendKeys("abcd");
		driver.findElementById("loginbutton").click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.quit();
		
		

		
        
		
		

	}

}
