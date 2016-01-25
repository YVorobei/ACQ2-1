package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.WebElementsActions;

import java.io.IOException;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class LoginPage {

    WebDriver driver;
    WebElementsActions web;

    //Logger log = Logger.getLogger(this.getClass());
    Logger log = Logger.getLogger(LoginTests.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }


    public void fillEmailField(String value) {
        try {
            web.clearAndInput("EmailField", value);
            log.info("input to EmailField - " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillPasswordfield(String value) {
        try {
            web.input("PassField", value);
            log.info("input to PassField - " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pressLoginButton() {
        try {
            web.clickButton("LoginButton");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkErrorShown(String locator) throws IOException {
        if (web.isElementPresent(locator)) {
            log.info("Error is present");
            return true;
        } else {
            log.error("Error is not present!");
            return false;
        }
    }
}
