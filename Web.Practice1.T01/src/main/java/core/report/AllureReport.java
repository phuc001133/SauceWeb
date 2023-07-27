package core.report;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AllureReport {

    public WebDriver driver;

    public AllureReport(WebDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "Image: {imageName}", type = "image/png")
    public byte[] saveScreenshot(String imageName) throws IOException {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void writeEnvironmentConfig(String browserName, String operator, String javaJDK, String linkWebsiteTesting)
    {

        try {
            File environment = new File("allure-results/environment.properties");

            Writer writer = new FileWriter(environment);

            writer.write("browser_name=" + browserName);
            writer.write("\n");

            writer.write("operating_system=" + operator);
            writer.write("\n");

            writer.write("java_jdk=" + javaJDK);
            writer.write("\n");

            writer.write("link_website_testing=" + linkWebsiteTesting);

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
