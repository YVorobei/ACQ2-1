package pages;

import exception.NoElementFound;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import utils.WebElementsActions;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class MainPage {

    WebDriver driver;
    WebElementsActions web;

    //Logger log = Logger.getLogger(this.getClass());
    private static final Logger log = Logger.getLogger(MainPage.class);


    public MainPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void clickLogo() {
        try {
            web.clickLink("Logo");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
        log.info("click on logo link");
    }

    public void switchToLoginPage() {
        try {
            web.clickLink("LoginLink");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
        log.info("click on LoginLink");

        try {
            if (web.isElementPresent("EmailField")) {
                log.info("SwitchTo Login Page was correct - " + web.getElement("EmailField").getText());
            } else {
                log.error("SwitchTo Login Page was INCORRECT - " + web.getElement("EmailField").getText());
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }


    public boolean isUserLoggedIn() {
        try {
            if (web.isElementPresent("LogoutLink")) {
                log.info("Login was correct");
                return true;
            } else {
                log.error("Login was INcorrect");
                return false;
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        return false;
    }

    public boolean isUserLogOut() {
        try {
            if (web.isElementPresent("LoginLink")) {
                log.info("LogOut was correct");
                return true;
            } else {
                log.error("LogOut was INcorrect");
                return false;
            }
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }

        return false;
    }


    public void userLogOut() {
        web.waitForElementPresent("LogoutLink");
        try {
            web.clickLink("LogoutLink");
            log.info("User Logout correct");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
        }
    }

    public void openMainPage() {
        web.openPage("http://www.ellos.se/");
    }

    public void refreshPage() {
        web.refreshPage();
        log.info("Refresh page");
    }
}
