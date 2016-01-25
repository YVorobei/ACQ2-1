package trainings.junit.simple1.sample6;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumClassFixture {

  protected static WebDriver driver;

  @BeforeClass
  public static void setUp() {
    System.out.println("Starting a browser");
    driver = new FirefoxDriver();
  }

  @AfterClass
  public static void tearDown() {
    System.out.println("Stopping the browser");
    if (driver != null) {
      driver.quit();
    }
  }

}
