package tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;


/**
 * Created by ViTaLES on 16.01.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTests {

    private static WebDriver driver;
    static MainPage mainPage;
    static LoginPage loginPage;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();

        System.out.println("Browser open successful");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1200, 800));
        System.out.println("Start test");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void test1_positiveLogin() {
        System.out.println(mainPage);
        System.out.println(loginPage);

        mainPage.openMainPage();
        mainPage.refreshPage();
        mainPage.switchToLoginPage();

        loginPage.fillEmailField("b.handozhynski@gmail.com");
        loginPage.fillPasswordfield("123456");

        loginPage.pressLoginButton();
        mainPage.userLogOut();

        Assert.assertTrue(mainPage.isUserLogOut());
    }


    @Test
    public void test2_negativeLogin() {
        mainPage.switchToLoginPage();

        loginPage.fillEmailField("admin@gmail.com");
        loginPage.fillPasswordfield("Password01");
        loginPage.pressLoginButton();

        Assert.assertTrue("Incorrect login to the system with fake log/pass", loginPage.isErrorShown("ErrorMess"));
    }

    @Test
    public void test3_blankEmailField() {
        mainPage.switchToLoginPage();

        loginPage.fillEmailField(" ");
        loginPage.fillEmailField("");
        loginPage.fillPasswordfield("Password01");
        loginPage.pressLoginButton();

        Assert.assertTrue("Error mass NOT shown in case blank Email Field", loginPage.isErrorShown("ErrorMess"));
    }


    @Test
    public void test4_blankPasswordField() {

        loginPage.fillEmailField("admin@gmail.com");
        loginPage.fillPasswordfield("");
        loginPage.pressLoginButton();

        Assert.assertTrue("Error mass NOT shown in case blank Pass Field", loginPage.isErrorShown("EmptyPassError"));

    }

    @Test
    public void test5_blankEmailAndPasswordField() {

        loginPage.fillEmailField("");
        loginPage.fillPasswordfield("");
        loginPage.pressLoginButton();

        Assert.assertTrue("Error mass NOT shown in case blank Pass Field", loginPage.isErrorShown("EmptyPassError"));

    }


    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("End test");
        driver.quit();
    }

}
