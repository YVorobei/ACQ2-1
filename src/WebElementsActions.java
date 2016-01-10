import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by ViTaLES on 10.01.2016.
 */
public class WebElementsActions {

    public WebDriver driver;

    public WebElementsActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click a button
     */
    public void clickButton(String buttonLocator) {
        driver.findElement(By.xpath(buttonLocator)).click();
        //log.info("Click on Button " + buttonLocator);
    }

    /**
     * Click link
     */
    public void clickLink(String linkLocator) {
        driver.findElement(By.xpath(linkLocator)).click();
        //log.info("Click on Link " + linkLocator);
    }

    /**
     * Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData) {
        driver.findElement(By.xpath(inputLocator)).clear();
        driver.findElement(By.xpath(inputLocator)).sendKeys(inputData);
        //log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    /**
     * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) {
        driver.findElement(By.xpath(inputLocator)).clear();
        driver.findElement(By.xpath(inputLocator)).sendKeys(inputData);
        driver.findElement(By.xpath(inputLocator)).sendKeys(Keys.ENTER);
    }

    /**
     * Select/deselect the checkbox, the second parameter should be "Y" or "N"
     */
    public void selectCheckbox(String checkboxLocator, String ischeckboxSelect) {
        if (driver.findElement(By.xpath(checkboxLocator)).isSelected() & ischeckboxSelect.equals("N")) {
            driver.findElement(By.xpath(checkboxLocator)).click();
        }
        if (!driver.findElement(By.xpath(checkboxLocator)).isSelected() & ischeckboxSelect.equals("Y")) {
            driver.findElement(By.xpath(checkboxLocator)).click();
        }
    }

    /**
     * Method is used to check that element is present on page.
     */
    public boolean isElementPresent(String elementLocator) {
        if (!driver.findElement(By.xpath(elementLocator)).isDisplayed()) {
            return false;
        }
        return true;
    }

    /**
     * This method is used to agree messages on pop-up windows
     */
    public boolean isAlertPresentAndAccept() {
        boolean alertPresence = false;
        try {
            Alert alert = driver.switchTo().alert();
            alertPresence = true;
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
            return alertPresence;
        }
        return alertPresence;
    }



    /**
     * This method is used to get text from pop-up windows
     */
    public String getAlertText() {
        String alertText;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            //log.info("Alert text: " + alertText);
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
            //log.error("Alert is not found");
            ex.printStackTrace();
        }
        return alertText;
    }


    public void moveToElementAndClick(String moveToLocator, String clickToElement) {
        WebElement webElement = null;
        webElement = driver.findElement(By.xpath(moveToLocator));

        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();
        clickButton(clickToElement);

        //log.info("moved To Element " + moveToLocator + "and clicked on" + clickToElement);
    }

    /**
     *Method#1 for refresh page
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }


}