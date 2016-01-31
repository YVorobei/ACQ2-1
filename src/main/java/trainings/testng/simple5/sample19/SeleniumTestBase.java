package trainings.testng.simple5.sample19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.MainPage;
import utils.WebElementsActions;

import java.util.concurrent.TimeUnit;

public class SeleniumTestBase {

  protected static WebDriver driver;
  static MainPage mainPage;
  static LoginPage loginPage;


  @BeforeSuite(alwaysRun = true)
  public void startBrowser() {
    driver = new FirefoxDriver();

    System.out.println("Browser open successful");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    System.out.println("Start test");
    mainPage = new MainPage(driver);
    loginPage = new LoginPage(driver);
  }

  @AfterSuite(alwaysRun = true)
  public void stopBrowser() {
    if (driver != null) {
      driver.quit();
    }
  }

}
