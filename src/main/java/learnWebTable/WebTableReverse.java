package learnWebTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableReverse {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://erail.in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("mas",Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("sbc",Keys.TAB);
		driver.findElementById("chkSelectDateOnly").click();
		Thread.sleep(3000);
				//trainName.click();
		WebElement ele1 = driver.findElementByXPath("//a[text()='Train Name']");
		ele1.click();
		
		List<String> trains = new ArrayList<String>();
		
		List<WebElement> elements = driver.findElementsByXPath("//table[@class='DataTable TrainList']//tr/td[2]");
		for (WebElement webElement : elements) {
			String text = webElement.getText();
			trains.add(text);
		}	
		
		Collections.reverse(trains);
		WebDriverWait  wait =  new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='DataTable DataTableHeader TrainList']//td[@class='Sorted']/a"))).click();
		WebElement ele2 = driver.findElementByXPath("//table[@class='DataTable DataTableHeader TrainList']//td[@class='Sorted']/a");
				ele2.click();
		//Thread.sleep(3000);
			

		List<String> reversedTrains =new ArrayList<String>();
		List<WebElement> trainsName = driver.findElementsByXPath("//table[@class='DataTable TrainList']//tr/td[2]");
		for (WebElement sortedList : trainsName) {
			String text = sortedList.getText();
			reversedTrains.add(text);
			
		}
		if(trains.equals(reversedTrains)){
			System.out.println("Train names are reverse sorted");
		}
		else {
			System.out.println("Train names are not reverse sorted");
		}
		
		}
	


	}


