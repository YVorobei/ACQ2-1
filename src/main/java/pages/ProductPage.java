package pages;

import exception.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * Created by ViTaLES on 31.01.2016.
 */
public class ProductPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ProductPage(WebDriverWrapper dr) {
        super(dr);
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


    public void choseSize() {
        web.waitForElementPresent("SizeDropDown");
        try {
            web.clickButton("SizeDropDown");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
        try {
            web.moveToElementAndClick("aaa", "ccc");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }
}
