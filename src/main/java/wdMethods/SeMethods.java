package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

public class SeMethods /*extends LearnExtentReport*/ implements WdMethods{

	RemoteWebDriver driver;
	int i=1;
	
	@Override
	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The browser "+browser+" launched");
		} catch (NullPointerException e) {
			
			e.printStackTrace();
			System.err.println("Browser could not be launched");
			throw new NullPointerException("Browser not launched");
		}
		}
		

	

	@Override
	public WebElement locateElement(String locator, String locValue) {
		
		try {
			switch(locator) {
			case "id":    return driver.findElementById(locValue);
			
			case "class": return  driver.findElementByClassName(locValue);
			
			case "link":  return driver.findElementByLinkText(locValue);
			
			case "xpath" :  return driver.findElementByXPath(locValue);
			
			case "name" : return driver.findElementByName(locValue);
			
			default: return null;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element could not be found");
			//throw new RuntimeException("Element "+locValue+" could not be found");
		}catch (WebDriverException e){
			System.err.println("Unknown error");
		}
		return null;
	}

	@Override
	public WebElement locateElement(String locValue) {
		WebElement ele=null;
		try {
			ele= driver.findElementById(locValue);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error");
		}
		//return driver.findElementByClassName(locValue);
		return ele;
	}

	@Override
	public void type(WebElement ele, String data) {
		
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The text "+data+" is entered");
			
		} catch (NoSuchElementException e) {
			
			System.err.println("Unable to locate the element");
		}catch (WebDriverException e){
			System.err.println("Error in "+ele+ " ");
		}
		finally{
		}
			takeSnap();
		}
	

	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (NoSuchElementException e) {
			
			System.err.println("Element could not be found");
		}finally{
		takeSnap();
		}
	}

	@Override
	public void clickNoSnap(WebElement ele) {
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (NoSuchElementException e) {
			
			System.err.println("Element could not be found");
		}

	}

	@Override
	public String getText(WebElement ele) {
		String txt= null;
		try {
			 txt = ele.getText();
			if (txt.isEmpty()){
				System.out.println("Empty field");
				}
			else 
			{
				return txt;
				//System.out.println(txt);
			}
		} catch (Exception e) {
			
		}finally{
		takeSnap();
		}
		return txt;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select dropdown = new Select(ele);
			dropdown.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			
			System.err.println("Dropdown element not found");
		}finally {
		takeSnap();
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		Select dropdown = new Select(ele);
		List<WebElement> options = dropdown.getOptions();
		dropdown.selectByIndex(options.size());
		//takeSnap();

	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(expectedTitle)){
			
			System.out.println("Title is " + expectedTitle);
			return true;
		}
		else{
		return false;
	}
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		String enteredText = ele.getText();
		if (enteredText.equalsIgnoreCase(expectedText))
		{
			System.out.println("The entered text" +enteredText+ "is correct");
			
		}else 
		{
			System.out.println("The entered text" +enteredText+ "is incorrect");
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		String enteredText = ele.getText();
		if (enteredText.contains(expectedText))
		{
			System.out.println("The entered text" +enteredText+ "contains the " + expectedText + "");
			
		}else 
		{
			System.out.println("The entered text"+enteredText+ "doesnt contain the" + expectedText + "");
		}
        
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		  if (ele.getAttribute(attribute).equals(value))
		  {
			  System.out.println("Atrribute is" +attribute+ "and value is"+value+ "");
		  }
		  else
		  {
			  System.out.println("Attribute value does not match");
		  }
		

	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		if (ele.getAttribute(attribute).equals(value))
		  {
			  System.out.println("Atrribute " +attribute+ "and value "+value+ "matches exactly");
		  }
		  else
		  {
			  System.out.println("Attribute value does not match");
		  }

	}

	@Override
	public void verifySelected(WebElement ele) {
		if (ele.isSelected())
		{
			System.out.println(""+ele+ "element is selected" );
		}

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToWindow(int index) {
        Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindows = new ArrayList<>();
		allWindows.addAll(windowHandles);
		String currentwindow = allWindows.get(index);
        driver.switchTo().window(currentwindow);
        System.out.println(driver.getTitle());
        //takeSnap();
	}

	@Override
	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);

	}

	@Override
	public void acceptAlert() {
		driver.switchTo().alert().accept();
		
		System.out.println("Alert accepted");
		//takeSnap();

	}

	@Override
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
        System.out.println("Alert dismissed");
        //takeSnap();
	}

	@Override
	public String getAlertText() {
		String alrt_txt = driver.switchTo().alert().getText();
		return alrt_txt;
		
	}


	public long takeSnap() {
		long num = (long) Math.floor(Math.random() * 9000000000L)+ 10000000L;
		
		try{
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),new File("./reports/images/"+num+".jpg"));
		}
		catch(WebDriverException e){
			System.out.println("Browser is closed");
		}
		catch(IOException e){
			System.out.println("Snapshot could not be taken");
		}
		return num;
	}

	@Override
	public void closeBrowser() {
		driver.close();

	}

	@Override
	public void closeAllBrowsers() {
		driver.quit();

	}

}
