package automationCucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = "message:target/cucumber-report.json")
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

}
