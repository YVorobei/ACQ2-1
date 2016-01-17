import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class MainPage {

    WebDriver driver;
    WebElementsActions web;

    //Logger log = Logger.getLogger(this.getClass());


    public MainPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void clickLogo() {
        try {
            web.clickLink("Logo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToLoginPage() {
        try {
            web.clickLink("LoginLink");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (web.isElementPresent("EmailField")) {
                System.out.println("SwitchTo Login Page was correct");
            } else {
                System.out.println("SwitchTo Login Page was Incorrect");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
