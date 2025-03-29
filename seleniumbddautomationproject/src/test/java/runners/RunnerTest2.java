package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = {"features/Login.feature","features/LoginWithScenarioOutlineExample.feature"},		
glue = {"steps"},
plugin = {"html:target/cucumber/cucumber-test-report.html","json:target/cucumber/cucumber-test-report.json"}
		)
public class RunnerTest2 extends AbstractTestNGCucumberTests{

}
