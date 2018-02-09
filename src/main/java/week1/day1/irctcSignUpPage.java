package week1.day1;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//import java.util.List;


public class irctcSignUpPage {

	public static void main(String[] args) throws InterruptedException {
		
		
		//FirefoxBinary fb = new FirefoxBinary(new File("C:\\Program Files\\MozillaFirefox\\firefox.exe"));
		
		//FirefoxOptions option = new FirefoxOptions();
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		
		//ChromeDriver driver=new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().window().maximize();
		
		/*driver.findElementById("userRegistrationForm:userName").sendKeys("anyname");
		//driver.findElementByLinkText("Check Availability").click();
		
		
		driver.findElementById("userRegistrationForm:password").sendKeys("abcdef");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("abcdef");
		
		WebElement dd1 = driver.findElementById("userRegistrationForm:securityQ");
		Select dropdown = new Select(dd1);
		//List<WebElement> options = dropdown.getOptions();
		dropdown.selectByVisibleText("Who was your Childhood hero?");
		
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Rajini");
		
		WebElement dd2 = driver.findElementById("userRegistrationForm:prelan");
		Select dropdown2 = new Select(dd2);
		//List<WebElement> options2 = dropdown2.getOptions();
		dropdown2.selectByValue("en");
		
		driver.findElementById("userRegistrationForm:firstName").sendKeys("abcdef");
		driver.findElementById("userRegistrationForm:middleName").sendKeys("xxxxx");
		driver.findElementById("userRegistrationForm:lastName").sendKeys("yyyyy");
		WebElement radiobtn = driver.findElementById("userRegistrationForm:gender:1");
		radiobtn.click();
		
		WebElement radiobtn2 = driver.findElementById("userRegistrationForm:maritalStatus:0");
		radiobtn2.click();
		
		WebElement dd3 = driver.findElementById("userRegistrationForm:dobDay");
		Select dropdown3 = new Select(dd3);
		//List<WebElement> options3 = dropdown3.getOptions();
		dropdown3.selectByValue("06");
		
		WebElement dd4 = driver.findElementById("userRegistrationForm:dobMonth");
		Select dropdown4 = new Select(dd4);
		//List<WebElement> options4 = dropdown4.getOptions();
		dropdown4.selectByValue("08");
		
		WebElement dd5 = driver.findElementById("userRegistrationForm:dateOfBirth");
		Select dropdown5 = new Select(dd5);
		//List<WebElement> options5 = dropdown5.getOptions();
		dropdown5.selectByValue("1996");
		
		WebElement dd6 = driver.findElementById("userRegistrationForm:occupation");
		Select dropdown6 = new Select(dd6);
		//List<WebElement> options6 = dropdown6.getOptions();
		dropdown6.selectByIndex(2);
        
		driver.findElementById("userRegistrationForm:uidno").sendKeys("2345567788");
		
		driver.findElementById("userRegistrationForm:idno").sendKeys("2345567ghhj");
		
		WebElement dd7 = driver.findElementById("userRegistrationForm:countries");
		Select dropdown7 = new Select(dd7);
		//List<WebElement> options7 = dropdown7.getOptions();
		dropdown7.selectByVisibleText("India");
		

		*/
        
		
		

	}

}
