package core.actionkeyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionKeyword {
    WebDriver driver;
    WebDriverWait wait;

    public ActionKeyword(WebDriver driver) {
        this.driver = driver;
        //Explicit wait will pause excute script until satisfied with a condition or maximum time has elapsed
        wait = new WebDriverWait(this.driver, 10);
    }

    /**
     * move to element and perform click element
     *
     * @param element want to click
     */
    public void click(WebElement element) {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    /**
     * Input a string in the specified element
     *
     * @param element want to input text
     * @param text    : content text want to input
     */
    public void setText(WebElement element, String text) {
        try {
            //clear content text if have before input text
            element.clear();
            if (element.isEnabled()) {
                //input content text if is enable to input
                element.sendKeys(text);
            }

        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not enable to set text");
        }

    }

    /**
     * perform select option of drop down list element
     *
     * @param element drop down list element
     * @param type    select by index/text/value
     * @param option  value option want to select
     * @throws Exception
     */
    public void select(WebElement element, SelectType type, String option) throws Exception {
        Select select = new Select(element);
        switch (type) {
            case SELECT_BY_INDEX:
                try {
                    select.selectByIndex(Integer.parseInt(option));
                } catch (Exception e) {
                    throw new Exception("please input numberic on select by index");
                }
                break;

            case SELECT_BY_TEXT:
                select.selectByVisibleText(option);
                break;

            case SELECT_BY_VALUE:
                select.selectByValue(option);
                break;

            default:
                throw new Exception("Get error in using Selected");

        }
    }

    public enum SelectType {
        SELECT_BY_INDEX,
        SELECT_BY_TEXT,
        SELECT_BY_VALUE
    }

}
