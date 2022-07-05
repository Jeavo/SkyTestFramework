package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DealsPage {

	WebDriver driver;
	
	
	//Element declarations
	By skyQButton = By.xpath("//span[contains(.,'Sky Q')]");
	
	By offer1Name = By.xpath("//p[contains(.,'Sky Q, Sky TV & Netflix')]");
	By offer1Value = By.xpath("//span[contains(.,'£26')]");
	
	By offer2Name = By.xpath("//p[contains(.,'Sky Q, Sky TV, Netflix & Sky Sports')]");
	By offer2Value = By.xpath("//span[contains(.,'£46')]");

	By offer3Name = By.xpath("//p[contains(.,'Sky Q, Sky TV, Netflix & Cinema')]");
	By offer3Value = By.xpath("//span[contains(.,'£38')]");
	
	//Initialising the local driver
	public DealsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Verifies the deals page has loaded successfully
	public void verifyDealsPage(WebDriver driver, String productName) {
		
		boolean testUrl = driver.getCurrentUrl().contains(productName);
		Assert.assertEquals(true, testUrl);
		
		if (testUrl == false) {
			
			System.out.println("The URL does not contain " + productName);
		}
		else {
	
			System.out.println("The " + productName + " page has loaded successfully");
		}
	}
	
	
	public void selectSkyQButton(WebDriver driver) {
		
		driver.findElement(skyQButton).click();
		
	}
	
	//Offer Value getters
	public String returnOffer1Name(WebDriver driver) {
		String strOffer1Name = driver.findElement(offer1Name).getText();
		return strOffer1Name;
	}
	
	public String returnOffer2Name(WebDriver driver) {
		String strOffer2Name = driver.findElement(offer2Name).getText();
		return strOffer2Name;
	}
	
	public String returnOffer3Name(WebDriver driver) {
		String strOffer3Name = driver.findElement(offer3Name).getText();
		return strOffer3Name;
	}
	
	
	
	public String returnOffer1Value(WebDriver driver) {
		String strOffer1Value = driver.findElement(offer1Value).getText();
		return strOffer1Value;
	}
	
	public String returnOffer2Value(WebDriver driver) {
		String strOffer2Value = driver.findElement(offer2Value).getText();
		return strOffer2Value;
	}
	
	public String returnOffer3Value(WebDriver driver) {
		String strOffer3Value = driver.findElement(offer3Value).getText();
		return strOffer3Value;
	}

	
}
