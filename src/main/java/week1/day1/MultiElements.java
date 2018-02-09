package week1.day1;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;;

public class MultiElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		List<WebElement> all = driver.findElementsByTagName("a");
		
		System.out.println(all.size());
		all.get(all.size()-1).click();
		System.out.println(driver.getCurrentUrl());
		
		
		
		

	}

}
