package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.DealsPage;
import po.HomePage;
import utilities.GenericFunctions;

public class Deals {

	public static WebDriver driver;

	static Hooks hooks = new Hooks();
	static HomePage home = new HomePage(driver);
	static DealsPage deals = new DealsPage(driver);
	static GenericFunctions genericFunctions = new GenericFunctions(driver);


	@Given("I am on the home page") public void i_am_on_the_home_page() {

		driver = hooks.getDriver();
		String strPageName = "home"; 
		String url = genericFunctions.getUrl(strPageName);

		//Opens Browser and accepts cookies
		genericFunctions.startBrowser(driver, url);
		genericFunctions.acceptCookies(driver);
	
	}
	
	
	@Given("I am on the deals page")
	public void i_am_on_the_deals_page() {

		driver = hooks.getDriver();
		String strPageName = "deals"; 
		String url = genericFunctions.getUrl(strPageName);
		
		//Opens Browser and accepts cookies
		genericFunctions.startBrowser(driver, url);
		genericFunctions.acceptCookies(driver);
		
	}


	@When("^I navigate to ([^\"]*)$")
	public void i_navigate_to_page(String strPage) {

		//Navigates to desired page
		genericFunctions.navigateTo(driver, strPage);

	}

	@Then("^the user should be on ([^\"]*)$")
	public void the_user_should_be_on_page(String strPage) {

		//Verifies Deals page is present
		deals.verifyDealsPage(driver, strPage);
		driver.quit();

	}
	
	@Then("I see a list of deals with a price to it")
	public void i_see_a_list_of_deals_with_a_price_to_it() {
		
		//Selects Sky Q to populate deals
		deals.selectSkyQButton(driver);
		
		//Asserts deals are as expected
		String expOffer1Value = "£26";
		boolean checkOffer1 = deals.returnOffer1Value(driver).contains(expOffer1Value);
		Assert.assertEquals(true, checkOffer1);
		
		String expOffer2Value = "£46";
		boolean checkOffer2 = deals.returnOffer2Value(driver).contains(expOffer2Value);
		Assert.assertEquals(true, checkOffer2);
		
		String expOffer3Value = "£38";
		boolean checkOffer3 = deals.returnOffer3Value(driver).contains(expOffer3Value);
		Assert.assertEquals(true, checkOffer3);

	}

}
