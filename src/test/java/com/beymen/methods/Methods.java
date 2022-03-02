package com.beymen.methods;

import com.beymen.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger= LogManager.getLogger(Methods.class);

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
        logger.info("Elemente tiklandi");
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
            logger.info("Bekleme yapidi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);

    }

    public void pressEnter(By by) {
        findElement(by).sendKeys(Keys.ENTER);
        logger.info("Enter tusuna basildi");
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("Baglanti dogru");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
        logger.info("Elemente scroll edildi");

    }

    public void scrollWithJavaScript(By by) {
        jsdriver.executeScript("arguments[0].scrollIntoView();", findElement(by));

    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public void selectByValue(By by, String text){
        getSelect(by).selectByValue(text);
        logger.info("Value degeri secildi");
    }

    public void clickRandomElement(By by) {
        Random random = new Random();
        List<WebElement> products = driver.findElements(by);
        int index = random.nextInt(products.size());
        products.get(index).click();
        logger.info("Rastgele elemente tiklandi");
    }

}
