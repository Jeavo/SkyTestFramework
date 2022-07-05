package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Features", 
		glue={"stepDefinitions"},
		plugin= {"pretty", "html:target/cucumber-reports"},
		tags= "@Test1"
		)

public class RunTest {

}
