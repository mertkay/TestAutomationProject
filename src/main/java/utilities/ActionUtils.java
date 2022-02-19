package utilities;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class ActionUtils {

    public static void clickFunction(WebDriver driver, WebElement element) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
        catch (Exception e)
        {
            Log4j.info("Element click function" + e);
        }
    }

    public static void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated((By) element));
        }
        catch (Exception e)
        {
            Log4j.info("Wait element function" + e);
        }
    }

    public static void sendKeysFunction(WebDriver driver, WebElement element, String text) {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        }
        catch (Exception e)
        {
            Log4j.info("Element click function" + e);
        }
    }

    public static void waitUntilVisibilityOfElement(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public static String getText(WebDriver driver, WebElement element) {
        return element.getText();
    }

    public static void Assertion(WebDriver driver, WebElement actual, String expected) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText(), expected);
        System.out.println("Title" + actual.getText());
    }


    public static void scrollToElement(WebDriver driver, WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(1500);
    }

    public static void screenshot(WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File image = screenshot.getScreenshotAs(OutputType.FILE);
        Files.move(image, new File("screenshots/" + "" + GetTimeStampValue() + ".png"));

    }

    public static boolean existsElement (WebDriver driver, By locator){
        try {
            driver.findElement(locator);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String GetTimeStampValue(){
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        String timestamp = time.toString();
        System.out.println(timestamp);
        String systime = timestamp.replace(":", "-");
        System.out.println(systime);
        return systime;
    }

}
