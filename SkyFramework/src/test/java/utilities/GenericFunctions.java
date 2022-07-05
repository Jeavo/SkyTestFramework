package utilities;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class GenericFunctions {
	
	public WebDriver driver;
	
	//Element declarations
	By acceptCookiesButton = By.xpath("//button[@title='Agree']");
	By dealsButton = By.xpath("//a[contains(.,'Deals')]");
	
	//Initialising the local driver
	public GenericFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	//Starts browser using string parameter and maximises window
	public void startBrowser(WebDriver driver, String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
		
	}
		
	//Returns URL of page name parameter
	public String getUrl(String strPageName) {
		
		switch(strPageName) {
			case "deals":
				strPageName = "https://www.sky.com/deals";
				break;
			case "home":
				strPageName = "https://www.sky.com";
				break;

		}
		return strPageName;
	}
	
	public void navigateTo(WebDriver driver, String strPage) {
		
		switch(strPage) {
		case "deals":
			driver.findElement(dealsButton).click();
			break;
		case "signIn":
			//driver.findElement(signInButton).click();
			

		}
		
	}
	
	
	
	public void acceptCookies(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Checking for iframe window which cookies buttons are contained within
		if (driver.getPageSource().contains("iframe")) {
			
			
			//Switches to iframe to interact with
			driver.switchTo().frame("sp_message_iframe_474555");
			
			@SuppressWarnings("unused")
			boolean cookieOn = driver.findElement(acceptCookiesButton).isDisplayed();
			
			if (cookieOn = true) {
				
				Duration timeOut = Duration.ofSeconds(5);
				WebDriverWait wait = new WebDriverWait(driver, timeOut);
				wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
				
				//Selecting the accept cookies button
				driver.findElement(acceptCookiesButton).click();
				//Wait necessary as other pages can throw extra cookies modal if accept button is selected too quickly
				wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookiesButton));
			}
		
		}
		
		
	}
	
}
