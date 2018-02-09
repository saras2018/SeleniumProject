package guru99bank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateLogin {

	public static void main(String[] args) throws InterruptedException {
			
		
				
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		ChromeDriver driver = new  ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElementByXPath("//input[@name='uid']").sendKeys("mngr111007");
		driver.findElementByXPath("//input[@name='password']").sendKeys("jujYzAq");
		driver.findElementByXPath("//input[@name='btnLogin']").click();
        String title = driver.getTitle();
        if (title.contains("Manager")) 
        { System.out.println("Pass");
        }
        else {
        	System.out.println("Fail");
        }
        
	   
	}
	
	/*public static Object launchBrowser() 
	{
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new  ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
		
	}

	public void doLogin(ChromeDriver d1)
	{
		launchBrowser();
		d1.findElementByXPath("//input[@name='uid']").sendKeys("mngr111007");
		d1.findElementByXPath("//input[@name='password']").sendKeys("jujYzAq");
		d1.findElementByXPath("//input[@name='btnLogin']").click();
        System.out.println(d1.getCurrentUrl());
	}*/
	

}
