package pageObjectModel;

import Runners.RunnerGenel;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends RunnerGenel {
    protected BasePage() {
        PageFactory.initElements(driver, this);
    }
}
