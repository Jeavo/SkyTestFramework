package po;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	WebDriver driver;
	
	//Element declarations
	By usernameInput = By.xpath("//*[@id='username']");
	By continueButton = By.xpath("//button[contains(.,'Continue')]");
	By errorText = By.xpath("//span[@id='error-desc']");
	

	//Initialising the local driver
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void enterUsername(WebDriver driver, String username) {
		
		Duration timeOut = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlContains("signin"));
		
		//Username input is contained within an iframe - necessary to be interacted with
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='iFrame containing Sky Sign-In application']")));
		
		//Enters usernames and clicks continue
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(continueButton).click();
		
	}
	
	public String getErrorText(WebDriver driver) {
		
		//Would have returned expected text but automated browser throws error message
		String strErrorText = driver.findElement(errorText).getText();
		return strErrorText;
		
	}
	
}
