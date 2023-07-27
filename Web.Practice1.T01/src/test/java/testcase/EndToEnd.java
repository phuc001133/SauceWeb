package testcase;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import testdata.SauceData;

import java.io.IOException;

public class EndToEnd extends BaseTest {

    @Epic("Login and perform order product with data from json")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login specific account, then click a product have name read from json file, add product to cart" + "\n"
                + "and click on check out. Fill information guest order and click Finish to complete order")
    @Test(priority = 1, dataProvider = "productDataFromJson", dataProviderClass = SauceData.class)
    public void verifyLoginAndOrderProduct(String username, String password, String product_name, String product_description, String firstname, String lastname, String postcode) throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputAccountAndClickLoginButton(username, password);

        ListProductPage listProductPage = new ListProductPage(driver);
        listProductPage.getProductByName(product_name);

        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickAddToCart();

        listProductPage.navigateToCartDetailPage();

        CartDetailPage cartDetailPage = new CartDetailPage(driver);
        cartDetailPage.clickButtonCheckout();

        CheckoutInformationOrder inforOrder = new CheckoutInformationOrder(driver);

        //check if username login is a problem or normal user
        if (username.equals("problem_user")) {

            //a test case will check button error display
            inforOrder.inputInformationCheckout(firstname, lastname, postcode);
            Assert.assertTrue(inforOrder.isErrorDisplay());

        } else if (!username.equals("problem_user")) {

            inforOrder.inputInformationCheckout(firstname, lastname, postcode);
        }

        if (!username.equals("problem_user")) {
            CheckoutOverview overviewOrder = new CheckoutOverview(driver);
            overviewOrder.clickFinishToCompleteOrder();

            CompleteOrderPage statusOrder = new CompleteOrderPage(driver);

            Assert.assertEquals(statusOrder.getStatusOrder(), "THANK YOU FOR YOUR ORDER");
        }
    }



}
