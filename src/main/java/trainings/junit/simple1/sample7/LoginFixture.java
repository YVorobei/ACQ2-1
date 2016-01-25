package trainings.junit.simple1.sample7;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class LoginFixture extends BrowserFixture {

  @BeforeClass
  public static void login() {
    System.out.println("Login");
    driver.get("http://google.com");
  }

  @AfterClass
  public static void logout() {
    System.out.println("Logout");
  }

}
