package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "/TestMailFun/features/login.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin = {"pretty", "html:target/cucumber"}
				 
		)


public class TestRun {

}
