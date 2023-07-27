package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class CheckoutOverview extends BasePage{
    public CheckoutOverview(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".summary_subtotal_label")
    private WebElement lblItemTotal;

    @FindBy(how = How.CSS, using = "#finish")
    private WebElement btnFinish;


    public void clickFinishToCompleteOrder() throws IOException {
        allureReport.saveScreenshot("Checkout Overview Page");
        actionKeyword.click(btnFinish);
    }

    public boolean isNumberic_ItemTotal() {
        String  itemTotal = lblItemTotal.getText();
        boolean isNumber = itemTotal.matches("\\w");
        return isNumber;
    }
}
