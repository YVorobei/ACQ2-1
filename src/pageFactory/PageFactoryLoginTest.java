package pageFactory;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 16.01.2016.
 */
public class PageFactoryLoginTest {

    WebDriver driver;
    PageFactoryMainPage pageFactoryMainPage;
    PageFactoryLoginPage pageFactoryLoginPage;

    //@Before
    public void setUp(){
        driver = new FirefoxDriver();
        System.out.println("Browser open successful");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.ellos.se/");
        System.out.println("Start test");
    }

    //@Test
    public void test1() throws IOException {
        pageFactoryMainPage = new PageFactoryMainPage(driver);
        pageFactoryMainPage.clickLogo();
        pageFactoryMainPage.switchToLoginPage();

        pageFactoryLoginPage = new PageFactoryLoginPage(driver);
        pageFactoryLoginPage.fillEmailField("admin@gmail.com");
        pageFactoryLoginPage.fillPasswordfield("Password01");
        pageFactoryLoginPage.pressLoginButton();

        Assert.assertTrue("Error is NOT present!", pageFactoryLoginPage.checkErrorShown());
    }

    //@After
    public void tearDown() {
        System.out.println("End test");
        driver.quit();
    }

}
