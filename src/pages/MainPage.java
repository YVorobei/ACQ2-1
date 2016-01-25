package pages;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import org.apache.log4j.Logger;
import utils.WebElementsActions;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class MainPage {

    WebDriver driver;
    WebElementsActions web;

    //Logger log = Logger.getLogger(this.getClass());
    Logger log = Logger.getLogger(MainPage.class);


    public MainPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void clickLogo() {
        try {
            web.clickLink("Logo");
            log.info("click on logo link");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToLoginPage() {
        try {
            web.clickLink("LoginLink");
            log.info("click on LoginLink");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (web.isElementPresent("EmailField")) {
                log.info("SwitchTo Login Page was correct");
            } else {
                log.error("SwitchTo Login Page was INCORRECT");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
