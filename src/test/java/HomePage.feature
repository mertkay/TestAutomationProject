Feature: HomePage Test

  Scenario: Hopi Anasayfasına gidilir ve Giris yap buttonuna tıklanır

    Given Hopi sitesine git
    And Hopi ikonu goruntulendigi kontrolu
    When Giris yap buttonuna tıkldıgımda
    Then Giriş yap text kontrolü