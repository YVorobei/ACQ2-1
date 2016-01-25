package trainings.testng.simple1.sample9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@Test
public class BrowserFixture {

  @BeforeTest
  public void setUp() {
    System.out.println("Starting a browser");
  }

  @AfterTest
  public void tearDown() {
    System.out.println("Stopping the browser");
  }

}
