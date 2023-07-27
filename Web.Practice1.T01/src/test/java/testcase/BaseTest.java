package testcase;

import core.configuration.Configuration;
import core.datadriven.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {

        Configuration configuration = new Configuration("src/test/resources/app.properties");

        driver = DriverFactory.getDriver(configuration.getProperty("browser"));

        driver.get(configuration.getProperty("url"));

    }


    @AfterMethod
    public void tearDown() throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.quit();

    }
}
