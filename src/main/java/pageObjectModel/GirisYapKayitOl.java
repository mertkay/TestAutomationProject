package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ActionUtils;

public class GirisYapKayitOl extends BasePage {

    @FindBy(xpath = "(//h5[@class=\"modal-title\"])[last()]")
    private WebElement baslik;

    public void assertTitle(){
        ActionUtils.Assertion(driver, baslik, "Giriş Yap veya Kayıt Ol");
    }
}
