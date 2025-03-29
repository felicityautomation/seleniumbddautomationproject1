package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = {"features/Login.feature"},
glue = {"steps"},
plugin = {"html:target/cucumber/cucumber-test-report.html","json:target/cucumber/cucumber-test-report.json","pretty"},
tags = "@positive or @negetive"
		)
public class RunnerTest3 extends AbstractTestNGCucumberTests{

}
