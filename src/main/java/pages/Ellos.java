package pages;

import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * Created by ViTaLES on 13.02.2016.
 */
public class Ellos {

    public MainPage mainPage;
    public LoginPage loginPage;
    public ProductPage productPage;

    public Ellos(WebDriverWrapper driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

}
