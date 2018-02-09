package actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MouseAction {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.findElementByLinkText("Sortable").click();
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		int y = driver.findElementByXPath("//li[text()='Item 4']").getLocation().getY();
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, 0, y).perform();
		
	
	
	}	
}
	
				
		


	


