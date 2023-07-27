package page;

import core.actionkeyword.ActionKeyword;
import core.report.AllureReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public ActionKeyword actionKeyword;

    public AllureReport allureReport;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.actionKeyword = new ActionKeyword(driver);
        allureReport = new AllureReport(this.driver);
    }
}
