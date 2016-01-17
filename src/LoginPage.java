import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class LoginPage {

    WebDriver driver;
    WebElementsActions web;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }


    public void fillEmailField(String value) {
        try {
            web.clearAndInput("EmailField", value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillPasswordfield(String value) {
        try {
            web.input("PassField", value);
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
            System.out.println("Error is present");
            return true;
        } else {
            System.out.println("Error is not present!");
            return false;
        }
    }
}
