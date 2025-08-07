package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;

public class MyHooks {
    private WebDriver driver;

    @Before
    public void before() {
        System.out.println("*************************** DRIVER STARTED *******************************");
        driver = DriverFactory.initializeDriver();
        System.out.println("Driver Initialized");
    }

    @After
    public void after() {
        driver.quit();
    }
}
