package pages;

import exception.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

/**
 * Created by ViTaLES on 31.01.2016.
 */
public class ProductPage {

    WebDriver driver;
    WebElementsActions web;

    //Logger log = Logger.getLogger(this.getClass());
    private static final Logger log = Logger.getLogger(ProductPage.class);


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }


    public void switchToPantiesCategory() {
        try {
            web.pressSpace();
            web.clickLink("Panties");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        if (web.waitForElementPresent("FirstProductOfPanties")) {
            log.info("SwitchTo Main Page was correct");
        } else {
            log.error("SwitchTo Main Page was INCORRECT");
        }
    }

    public void switchToFirstProductPage() {
        try {
            web.clickLink("FirstProductOfPanties");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        if (web.waitForElementPresent("ProductName")) {
            log.info("SwitchTo Panties Product page was correct");
        } else {
            log.error("SwitchTo Panties Product page was INCORRECT!");
        }
    }

    public boolean checkCorrectSwitchToProductPage() {
        try {
            if (web.isElementPresent("ProductName")) {
                log.info("Correct switch to product page");
                return true;
            } else {
                log.error("INCORRECT switch to product page!");
                return false;
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        return false;
    }


}
