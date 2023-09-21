package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
	(features=".//Features//Customers.feature",
	glue={"stepDefinitions"},
	monochrome = true,
	dryRun = false,
	plugin = {"pretty", "html: test-output"},
	tags=("@sanity")
	)
	

public class TestRunner {

}
