package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ActionUtils;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//img[@class=\"img-fluid active-img\"])[3]")
    private WebElement hopiIcon;
    //private yapmamın sebebi metotlarla çagırmak istedigim için

    @FindBy(xpath = "//a[@class=\"btn btn-fourth\"]")
    private WebElement girisyapBtn;

    @FindBy(xpath = "(//*[contains(@class,\"section-title\")])[4]")
    private WebElement elementscroll;

    public void clickGirisyapBtn(){
        ActionUtils.clickFunction(driver, girisyapBtn);
    }

    public void iconVisible(){
        ActionUtils.waitUntilVisibilityOfElement(driver, hopiIcon);
    }
    public void AssertColor(){
        try{
            System.out.println("try girdi");
            //String colorString = driver.findElement(By.id(String.valueOf(girisyapBtn))).getAttribute("class");
            //String[] arrColor = colorString .split("#");
            //Assert.assertTrue(arrColor[1].equals("e81f89"));
        }
        catch (Exception e){
            System.out.println("hata verdi");
        }

    }
    public void scroll() throws InterruptedException {
        ActionUtils.scrollToElement(driver,elementscroll);
    }
}
