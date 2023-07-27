package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class CartDetailPage extends BasePage{
    public CartDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".inventory_item_desc")
    private WebElement productDescription;


    @FindBy(how = How.CSS, using = "#checkout")
    private WebElement btnCheckout;

    public void clickButtonCheckout() throws IOException {
        allureReport.saveScreenshot("Cart Detail");
        actionKeyword.click(btnCheckout);
    }

    public String getProductDescription() {
        return productDescription.getText();
    }
}
