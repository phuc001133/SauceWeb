package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class CheckoutInformationOrder extends BasePage{
    public CheckoutInformationOrder(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "#first-name")
    private WebElement txtFirstname;

    @FindBy(how = How.CSS, using = "#last-name")
    private WebElement txtLastname;

    @FindBy(how = How.CSS, using = "#postal-code")
    private WebElement txtPostcode;


    @FindBy(how = How.CSS, using = ".error-button")
    private WebElement btnError;


    @FindBy(how = How.CSS, using = "#continue")
    private WebElement btnContinue;

    public void inputInformationCheckout(String firstname, String lastname, String postcode) throws IOException {

        actionKeyword.setText(txtFirstname, firstname);
        actionKeyword.setText(txtLastname, lastname);
        actionKeyword.setText(txtPostcode, postcode);

        allureReport.saveScreenshot("After fill information guest order");

        actionKeyword.click(btnContinue);

    }

    public boolean isErrorDisplay() throws InterruptedException {
        Thread.sleep(3000);
        return btnError.isDisplayed();
    }
}
