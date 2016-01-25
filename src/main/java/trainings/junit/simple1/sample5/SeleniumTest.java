package trainings.junit.simple1.sample5;

import org.junit.Test;

public class SeleniumTest extends SeleniumMethodFixture {

  @Test
  public void test1() {
    driver.get("http://google.com/");
  }

  @Test
  public void test2() {
    driver.get("https://www.facebook.com/");
  }

}
