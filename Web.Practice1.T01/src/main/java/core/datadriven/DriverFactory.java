package core.datadriven;

import core.configuration.Configuration;
import core.report.AllureReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class DriverFactory {

    /**
     * Opens up a browser window
     *
     * @param browser name want to start up
     * @return Opens up a browser window with the settings passed in
     */
    public static WebDriver getDriver(String browser) throws IOException {
        Configuration configuration = new Configuration("src/test/resources/app.properties");

        switch (browser) {
            case "chrome":

                //WebDriverManager is a library help controlling web browser
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("incognito");
                chromeOptions.addArguments("--kiosk");

                AllureReport.writeEnvironmentConfig(
                        chromeOptions.getBrowserName()
                        , System.getProperty("os.name")
                        , System.getProperty("java.version")
                        , configuration.getProperty("url"));

                //run and open a chrome browser with option setting
                return new ChromeDriver(chromeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--kiosk");
                firefoxOptions.addArguments("-private");

                AllureReport.writeEnvironmentConfig(
                        firefoxOptions.getBrowserName()
                        , System.getProperty("os.name")
                        , System.getProperty("java.version")
                        , configuration.getProperty("url"));
                return new FirefoxDriver(firefoxOptions);

            default:
                //run chrome browser if didn't get a browser name
                return new ChromeDriver();
        }
    }
}
