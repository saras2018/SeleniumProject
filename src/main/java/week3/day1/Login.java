package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import wdMethods.SeMethods;

public class Login {

	public static void main(String[] args) {
		SeMethods se = new SeMethods();
		se.startApp("firefox", "http://leaftaps.com/opentaps");
	
		//find user name 
		WebElement username = se.locateElement("id", "username");
		
		// and pass the value
		se.type(username, "DemoSalesManager");

		// find the password
		WebElement password = se.locateElement("id", "password");
		se.type(password, "crmsfa");
		
		// find the login
		WebElement login = se.locateElement("class", "decorativeSubmit");
		se.click(login);
		
		// find the CRM/SFA
		WebElement crmsfa = se.locateElement("link", "CRM/SFA");
		se.click(crmsfa);
	
		
		
		
	}

}