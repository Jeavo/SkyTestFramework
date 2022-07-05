package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	public static WebDriver driver;
	
	@Before
	public void setupBrowser() {
		
		//Sets the WebDriver
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\chromedriver.exe");
		driver = new ChromeDriver(); 

	}
	
	@After
	public void clearDown() {
		
		//Clears down the driver
		driver.quit();
	}
	
	
	//Returns the driver to be used across different classes
	public WebDriver getDriver() {
		return driver;
	}
	
	
}
