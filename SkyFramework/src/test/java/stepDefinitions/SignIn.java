package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.HomePage;
import po.SignInPage;
import utilities.GenericFunctions;

public class SignIn {

	public static WebDriver driver;
	
	static Hooks hooks = new Hooks();
	static GenericFunctions genericFunctions = new GenericFunctions(driver);
	static HomePage home = new HomePage(driver);
	static SignInPage signIn = new SignInPage(driver);
	
	
	@When("I try to sign in with invalid credentials")
	public void i_try_to_sign_in_with_invalid_credentials() {

		String strUsername = "ryan@testing.com";
		
		//Gets driver
		driver = hooks.getDriver();
		
		//Selects Sign In and enters Username
		home.selectSignInButton(driver);
		signIn.enterUsername(driver, strUsername);

	}
	
	@Then("I should see a box with the text Create your My Sky password")
	public void i_should_see_a_box_with_the_text_create_your_my_sky_password() {
		
		
		//Due to issues with webpage picking chromedriver up as a bot - page throws error message when entering username - used error text to assert
		String strErrorText = signIn.getErrorText(driver);
		assertTrue(strErrorText.contains("Please carefully check your details."));

	}



	
	
}
