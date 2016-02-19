package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pages.Ellos;
import utils.PropertyLoader;
import utils.WebDriverFactory;
import utils.WebDriverWrapper;

import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 31.01.2016.
 */
public class Fixture {

    public static WebDriverWrapper driverWrapper;
    public static Ellos ellos;

    private static final Logger log = Logger.getLogger(Fixture.class);
    private static final String implWait = PropertyLoader.loadProperty("wait.timeout");


    @BeforeSuite
    public void setEnv(){
        driverWrapper = new WebDriverWrapper(WebDriverFactory.getInstance());

        driverWrapper.manage().timeouts().implicitlyWait(Long.parseLong(implWait), TimeUnit.SECONDS);

        try {
            ellos = new Ellos(driverWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("Start Test Suite execution");
    }

    @AfterSuite
    public void resetEnv(){
        driverWrapper.quit();

        log.info("Tests Suite execution completed.");
    }


}
