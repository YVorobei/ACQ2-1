package pages;

import exception.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class LoginPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public LoginPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void fillEmailField(String value) {
        try {
            web.clearAndInput("EmailField", value);
            log.info("input to EmailField - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void fillPasswordfield(String value) {
        try {
            web.input("PassField", value);
            log.info("input to PassField - " + value);
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void pressLoginButton() {
        try {
            web.clickButton("LoginButton");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public boolean isErrorShown(String locator) {
        try {
            if (web.isElementPresent(locator)) {
                log.info("Error is present - " + web.getElement(locator).getText());
                return true;
            } else {
                log.error("Error is NOT present - " + web.getElement(locator).getText());
                return false;
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
        return false;
    }


    public void switchToMainPage() {
        try {
            web.clickLink("LogoOnLoginPage");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        try {
            if (web.isElementPresent("LandingContainer")) {
                log.info("SwitchTo Main Page was correct");
            } else {
                log.error("SwitchTo Main Page was INCORRECT");
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }


}
