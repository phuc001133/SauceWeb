package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.List;

public class ListProductPage extends BasePage {
    public ListProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".inventory_item_name")
    private List<WebElement> listProduct;

    @FindBy(how = How.CSS, using = "#shopping_cart_container")
    private WebElement btnCart;


    public void getProductByName(String product_name) throws IOException {
        allureReport.saveScreenshot("List product");
        for (WebElement product : listProduct) {
            if (product.equals(product_name)) {
                actionKeyword.click(product);
            }
        }
    }

    public void navigateToCartDetailPage() {
        actionKeyword.click(btnCart);
    }

}
