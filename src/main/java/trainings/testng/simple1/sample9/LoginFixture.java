package trainings.testng.simple1.sample9;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class LoginFixture extends BrowserFixture {

  @BeforeClass
  public void login() {
    System.out.println("Start ctest");

  }

  @AfterClass
  public void logout() {
    System.out.println("Finish tcest");
  }

}
