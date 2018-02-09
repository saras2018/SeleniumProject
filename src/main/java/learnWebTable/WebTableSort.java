package learnWebTable;

import java.util.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebTableSort {
	public static void main(String[] args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	
	RemoteWebDriver driver=new ChromeDriver();
	driver.get("https://erail.in");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.findElementById("txtStationFrom").clear();
	driver.findElementById("txtStationFrom").sendKeys("mas",Keys.TAB);
	driver.findElementById("txtStationTo").clear();
	driver.findElementById("txtStationTo").sendKeys("sbc",Keys.TAB);
	driver.findElementById("chkSelectDateOnly").click();
	Thread.sleep(3000);
	
	
	List<String> trains = new ArrayList<String>();
	
	List<WebElement> elements = driver.findElementsByXPath("//table[@class='DataTable TrainList']//tr/td[2]");
	for (WebElement webElement : elements) {
		String text = webElement.getText();
		trains.add(text);
	}	
	Collections.sort(trains);
	//Collections.reverse(trains);
	//System.out.println(trains);
	//System.out.println(trains.size());
	
	WebElement trainName = driver.findElementByXPath("//a[text()='Train Name']");
	Actions builder = new Actions(driver);
	builder.click(trainName).perform();
	List<String> sortedTrains =new ArrayList<String>();
	List<WebElement> trainsName = driver.findElementsByXPath("//table[@class='DataTable TrainList']//tr/td[2]");
	for (WebElement sortedList : trainsName) {
		String text = sortedList.getText();
		sortedTrains.add(text);
		
	}
	if(trains.equals(sortedTrains)){
		System.out.println("Train names are sorted");
	}
	else {
		System.out.println("Train names are not sorted");
	}
	
	}
}
