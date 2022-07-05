package po;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	
	//Element declarations
	By dealsButton = By.xpath("//a[contains(.,'Deals')]");
	By signInButton = By.linkText("Sign in");
	By searchButton = By.xpath("//*[@id='masthead-search-toggle']");
	By searchInput = By.xpath("//input[@data-test-id='input-box']");
	By searchResults = By.xpath("//*[@id='search-results-container']");
	By searchResultsHeader = By.xpath("//a[contains(.,'Sky offers')]");
	
	WebDriver driver;
	
	
	//Initialising the local driver
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectDealsButton(WebDriver driver) {

		driver.findElement(dealsButton).click();
		
	}
	
	public void selectSignInButton(WebDriver driver) {
		
		driver.findElement(signInButton).click();
		
	}
	
	public void selectSearchButton(WebDriver driver) {
		
		driver.findElement(searchButton).click();
		
	}
	
	public void enterSearchText(WebDriver driver, String searchInputText) {
		
		driver.findElement(searchInput).sendKeys(searchInputText);
		
	}
	
	
	//Waits for results to appear and returns text to a string
	public String returnSearchResults(WebDriver driver) {
		
		Duration timeOut = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(searchResults, "Sky offers"));
		
		String strSearchResults = driver.findElement(searchResults).getText();
		return strSearchResults;
	}
	
	
}
