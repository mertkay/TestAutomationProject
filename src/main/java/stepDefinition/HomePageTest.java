package stepDefinition;

import Runners.RunnerGenel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pageObjectModel.GirisYapKayitOl;
import pageObjectModel.HomePage;
import utilities.ActionUtils;
import utilities.Log4j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Test
public class HomePageTest extends RunnerGenel {

    HomePage homePage = new HomePage();
    GirisYapKayitOl girisYapKayitOl = new GirisYapKayitOl();
    ActionUtils utils = new ActionUtils();

    @Given("Hopi sitesine git")
    public void hopi_sitesine_git() {
        driver.manage().window().maximize();
        driver.get("https://hopi.com.tr");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        Log4j.startLog("Test başlıyor");
    }

    @And("Hopi ikonu goruntulendigi kontrolu")
    public void hopi_ikonu_goruntulendigi_kontrolu() throws IOException, InterruptedException {
        Log4j.info("Hopi icon görüntülendi");
        homePage.iconVisible();
        utils.screenshot(driver);
        homePage.scroll();
        utils.screenshot(driver);
    }

    @When("Giris yap buttonuna tıkldıgımda")
    public void giris_yap_buttonuna_tıkldıgımda() {
        Log4j.info("Ana sayfada giriş yap buttonuna tıklandı");
        homePage.clickGirisyapBtn();
    }

    @Then("Giriş yap text kontrolü")
    public void giriş_yap_text_kontrolü() {
        girisYapKayitOl.assertTitle();
        System.out.println("Giriş yap text kontrolü");
        Log4j.info("Giriş yap text kontrolü");
    }
}
