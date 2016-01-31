package tests;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;


/**
 * Created by ViTaLES on 16.01.2016.
 */
public class LoginTests extends Fixture {

    private static final Logger log = Logger.getLogger(LoginTests.class);

    @BeforeClass
    public void setUp() throws Exception {
        log.info("Start LoginTests");
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void test1_positiveLogin() {
        System.out.println(mainPage);
        System.out.println(loginPage);

        mainPage.openMainPage();
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

        Assert.assertTrue(loginPage.isErrorShown("ErrorMess"), "Incorrect login to the system with fake log/pass");
    }

    @Test
    public void test3_blankEmailField() {

        loginPage.fillEmailField(" ");
        loginPage.fillPasswordfield("Password01");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("ErrorMess"), "Error mass NOT shown in case blank Email Field");
    }


    @Test
    public void test4_blankPasswordField() {

        loginPage.fillEmailField("admin@gmail.com");
        loginPage.fillPasswordfield("");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("EmptyPassError"), "Error mass NOT shown in case blank Pass Field");

    }

    @Test
    public void test5_blankEmailAndPasswordField() {

        loginPage.fillEmailField("");
        loginPage.fillPasswordfield("");
        loginPage.pressLoginButton();

        Assert.assertTrue(loginPage.isErrorShown("EmptyPassError"), "Error mass NOT shown in case blank Pass Field");

        //cюда смотри!
        loginPage.switchToMainPage();
    }


    @AfterClass
    public static void tearDown() throws Exception {
        log.info("End LoginTests");
    }

}
