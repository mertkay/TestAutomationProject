package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class DriverManager {

    private static WebDriver driver;
        public static WebDriver getDriver (String browser){
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equals(("firefox"))) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver");
                driver = new FirefoxDriver();
            }
            return driver;
        }

        @AfterMethod
        public static void tearDown () {

            if (driver != null)
                driver.quit();
            driver = null;
        }

    /*
    WebDriver driver;
    ConfigurationManager configurationManager = new ConfigurationManager();

    public WebDriver createDriver(String browserName){
        switch (browserName){
            case "firefox":
                System.setProperty("webdriver.gecko.driver",configurationManager.getConfig("geckodriver.path"));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver",configurationManager.getConfig("chromedriver.path"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(configurationManager.getConfig("wait.ImlicitlyWait"), TimeUnit.SECONDS));
        return driver;
     */




/*
        if(driver==null)
          {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
            driver = new ChromeDriver();
          }
        return driver;

    }
    @AfterMethod
    public static void tearDown(){

        if (driver!=null)
        driver.quit();
        driver=null;
    }


 */
    }
