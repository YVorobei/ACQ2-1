import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageFactory.PageFactoryMainPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class LoginTests {

    private WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        System.out.println("Browser open successful");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//magic
        driver.get("http://www.ellos.se/");
        System.out.println("Start test");

    }

    @Test
    public void negativeLogin() throws Exception {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

        mainPage.clickLogo();
        mainPage.switchToLoginPage();

        loginPage.fillEmailField();
        loginPage.fillPasswordfield();

        loginPage.pressLoginButton();

        Assert.assertTrue("Incorrect login to the system with fake log/pass", loginPage.checkErrorShown(".//div[@id='serverValidationErrors']/ul"));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("End test");
        driver.quit();
    }

}
