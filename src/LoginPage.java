import org.openqa.selenium.WebDriver;

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


    public void fillEmailField() {
        web.clearAndInput(".//input[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginUsername']", "admin@gmail.com");
    }

    public void fillPasswordfield() {
        web.input(".//input[@id='LoginPasswordText']", "admin@gmail.com");
    }

    public void pressLoginButton() {
        web.clickButton(".//a[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginButton']");
    }

    public boolean checkErrorShown(String xpath) {
        if (web.isElementPresent(xpath)) {
            System.out.println("Error is present");
            return true;
        } else {
            System.out.println("Error is not present!");
            return false;
        }
    }
}
