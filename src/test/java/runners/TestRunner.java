package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/automationcucumber",
        glue = {"automationCucumber", "hooks"},
        plugin = {"pretty"},
        tags = "@A1 or @A2 or @A3 or @A4",
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
