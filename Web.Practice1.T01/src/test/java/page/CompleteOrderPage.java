package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class CompleteOrderPage extends BasePage{
    public CompleteOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".complete-header")
    private WebElement lblStatusOrder;

    public String getStatusOrder() throws IOException {
        allureReport.saveScreenshot("Complete order page");
        return lblStatusOrder.getText();
    }
}
