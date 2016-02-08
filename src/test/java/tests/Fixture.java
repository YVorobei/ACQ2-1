package tests;

import net.anthavio.phanbedder.Phanbedder;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductPage;
import utils.PropertyLoader;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by ViTaLES on 31.01.2016.
 */
public class Fixture {
    public static WebDriver driver;
    public MainPage mainPage;
    public LoginPage loginPage;
    public ProductPage productPage;

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String PHANTOMJS = "phantomjs";

    private static final Logger log = Logger.getLogger(Fixture.class);
    public static final String browserName = PropertyLoader.loadProperty("browser.name");

    @BeforeSuite
    public void setEnv(){
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "c:\\Tool\\chromedriver.exe");


        if(browserName.equals(FIREFOX)){
            driver = new FirefoxDriver();
        }else if(browserName.equals(PHANTOMJS)){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true); // enabled by default
            caps.setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    "C:/Tool/phantomjs-2.1.1-windows/bin/phantomjs.exe"
            );


            /*File phantomjs = new File("C:\\Tool\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
            System.setProperty("phantomjs.binary.path", phantomjs.getAbsolutePath());

            driver = new PhantomJSDriver();*/

        } else if(browserName.equals(CHROME)){
            driver = new ChromeDriver();
        } else {
            Assert.fail("invalid driver name");
        }

        log.info("Browser open successful");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void resetEnv(){
        /*if (driver != null){
            driver.quit();
            log.info("Browser close successful");
        }*/
        log.info("Tests Suite execution completed.");
    }


}
