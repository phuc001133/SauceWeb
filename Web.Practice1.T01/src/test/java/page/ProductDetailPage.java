package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "[id*='add']")
    private WebElement btnAddToCart;

    @Step("Click Add to Cart button to continue order process")
    public void clickAddToCart() throws IOException, InterruptedException {
        Thread.sleep(2000);
        allureReport.saveScreenshot("Product detail");
        actionKeyword.click(btnAddToCart);
    }


}
