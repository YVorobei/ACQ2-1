package tests;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;
import utils.Log4JWrapper;


/**
 * Created by ViTaLES on 16.01.2016.
 */
public class LoginTests extends Fixture {

    private static final Logger log = Logger.getLogger(LoginTests.class);

    @BeforeClass
    public void setUp() throws Exception {
        Log4JWrapper.start("Start LoginTests");
    }


    @Test
    public void test1_positiveLogin() {
        ellos.loginPage.openPage();

        ellos.mainPage.openPage();
        ellos.mainPage.switchToLoginPage();

        ellos.loginPage.fillEmailField("b.handozhynski@gmail.com");
        ellos.loginPage.fillPasswordfield("123456");

        ellos.loginPage.pressLoginButton();
        ellos.mainPage.userLogOut();

        Assert.assertTrue(ellos.mainPage.isUserLogOut());
    }


    //@Test
    public void test2_negativeLogin() {
        ellos.mainPage.switchToLoginPage();

        ellos.loginPage.fillEmailField("admin@gmail.com");
        ellos.loginPage.fillPasswordfield("Password01");
        ellos.loginPage.pressLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorShown("ErrorMess"), "Incorrect login to the system with fake log/pass");
    }

    //@Test
    public void test3_blankEmailField() {

        ellos.loginPage.fillEmailField(" ");
        ellos.loginPage.fillPasswordfield("Password01");
        ellos.loginPage.pressLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorShown("ErrorMess"), "Error mass NOT shown in case blank Email Field");
    }


    //@Test
    public void test4_blankPasswordField() {

        ellos.loginPage.fillEmailField("admin@gmail.com");
        ellos.loginPage.fillPasswordfield("");
        ellos.loginPage.pressLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorShown("EmptyPassError"), "Error mass NOT shown in case blank Pass Field");

    }

    //@Test
    public void test5_blankEmailAndPasswordField() {

        ellos.loginPage.fillEmailField("");
        ellos.loginPage.fillPasswordfield("");
        ellos.loginPage.pressLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorShown("EmptyPassError"), "Error mass NOT shown in case blank Pass Field");

        //cюда смотри!
        ellos.loginPage.switchToMainPage();
    }


    @AfterClass
    public static void tearDown() throws Exception {
        Log4JWrapper.end("End LoginTests");
    }

}
