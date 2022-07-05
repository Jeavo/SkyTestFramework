package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.HomePage;
import utilities.GenericFunctions;

public class Search {

	
	public static WebDriver driver;

	static Hooks hooks = new Hooks();
	static HomePage home = new HomePage(driver);
	static GenericFunctions genericFunctions = new GenericFunctions(driver);
	
	@When("I search Sky in the search bar")
	public void i_search_sky_in_the_search_bar() {

		driver = hooks.getDriver();
		
		String searchInputText = "Sky";
		
		//Selections search button and enters desired text
		home.selectSearchButton(driver);
		home.enterSearchText(driver, searchInputText);

	}
	
	
	@Then("I should see the editorial section")
	public void i_should_see_the_editorial_section() throws InterruptedException {
			
		
		//Returns search results and asserts they are as expected
		String expText = "Sky offers";
		String getText = home.returnSearchResults(driver);
		boolean textCheck = getText.contains(expText);
		Assert.assertEquals(true, textCheck);

	}


	
	
	
}
