package automationCucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(plugin = "message:target/cucumber-report.json")
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void beforeClass() {
        System.out.println("\nIN BEFORE CLASS\n");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\nIN AFTER CLASS\n");
    }
}
