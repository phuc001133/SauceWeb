package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "#user-name")
    private WebElement txtUsername;

    @FindBy(how = How.CSS, using = "#password")
    private WebElement txtPassword;

    @FindBy(how = How.CSS, using = "#login-button")
    private WebElement btnLogin;


    @Step("Fill username is {username} and password is {password}")
    public void inputAccountAndClickLoginButton(String username, String password) throws IOException {
        allureReport.saveScreenshot("Before enter account information");

        actionKeyword.setText(txtUsername, username);
        actionKeyword.setText(txtPassword, password);

        allureReport.saveScreenshot("After enter account information");

        actionKeyword.click(btnLogin);

    }
}
