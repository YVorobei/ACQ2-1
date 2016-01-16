import org.openqa.selenium.WebDriver;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class MainPage {

    WebDriver driver;
    WebElementsActions web;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        web = new WebElementsActions(driver);
    }

    public void clickLogo() {
        web.clickLink(".//a[@class='ellos active']");
    }

    public void switchToLoginPage() {
        web.clickLink(".//a[@id='showlogin']");
        if (web.isElementPresent(".//input[@id='ctl00_ctl00_conMain_conMain_LoginControl_LoginUsername']")) {
            System.out.println("SwitchTo Login Page was correct");
        } else {
            System.out.println("SwitchTo Login Page was Incorrect");
        }
    }

}
