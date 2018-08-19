package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="projectFeatures", 
		glue="stepDefenition",
		tags= {"@functionalTests", "~@ignore"},
		//dryRun = true
		monochrome = true
		)
public class TestRunner {

}
