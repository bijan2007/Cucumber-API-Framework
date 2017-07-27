package cucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Feature"
		,glue={"stepDefinition"}
		,monochrome=true
		,format = {"html:output"}
		)
public class TestRunner {
}
