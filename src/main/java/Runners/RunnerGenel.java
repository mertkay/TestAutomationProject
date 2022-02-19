package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.DriverManager;

@CucumberOptions(

    features={"src/test/java"},
    glue={"stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-html-report.html", "junit:target/cucumber-reports/Cucumber.xml", "json:target/Destination/cucumber.json"},
        monochrome = true
        //tags = {"@RegressionTest"}
)

public class RunnerGenel extends AbstractTestNGCucumberTests {

    private static TestNGCucumberRunner testNGCucumberRunner;
    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUpCucumber(String browser) {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        driver = DriverManager.getDriver(browser);
    }

    @AfterClass(alwaysRun = true)
    public static void closeDriver() {
        driver.quit();
        testNGCucumberRunner.finish();

    }
}

