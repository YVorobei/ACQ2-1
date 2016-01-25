package trainings.testng.simple1.sample8;

import org.testng.annotations.Test;

@Test
public class SeleniumTest extends SeleniumClassFixture {

  public void test1() {
    driver.get("http://ellos.se/");
  }

  public void test2() {
    driver.get("http://google.com/");
  }

}
