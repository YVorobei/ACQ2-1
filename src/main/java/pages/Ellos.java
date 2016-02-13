package pages;

import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * Created by ViTaLES on 13.02.2016.
 */
public class Ellos {

    public WebElementsActions web;
    public MainPage mainPage;
    public LoginPage loginPage;
    public ProductPage productPage;
    //public CheckoutPage checkoutPage;
    //public RegistrationPage registrationPage;
    //public MyCabinetPage mycabinetPage;
    //public ScreenShotMaker screenShotMaker;
    //public Mock mock;

    public Ellos(WebDriverWrapper driver) {
        web  = new WebElementsActions(driver);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        //checkoutPage = new CheckoutPage(driver);
        //registrationPage = new RegistrationPage(driver);
        //mycabinetPage = new MyCabinetPage(driver);

        //screenShotMaker = new ScreenShotMaker(driver);
        //mock = new Mock(driver);
    }

}
