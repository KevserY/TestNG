package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_Softassertion {
    @Test
    public void softAssertionTesti() {
        /*
               TestNG çoklu assertion içeren testlerde 2 alternatif sunuyor:

               1- JUnit'deki method'ların aynılarını kullanabiliriz.
                  Testimiz failed olan ilk assertion'da çalışmayı durdurur,
                  geriye kalan assertion'ların passed olup olmadığını bilmeyiz.
                  Failed olan assertion'ı düzelttikten sonra diğerlerine bakabiliriz.

                  Bu yöntemi kullandığımızda, failed olan her bir assertion için
                  düzeltmeleri yapıp yeniden testi çalıştırmamız gerekir.

               2- Sorfassert class'ından aynı assert methodlarını kullanabiliriz.
                  SoftAssert kullandığımızda TestNG Assertion'lar failde olsa da
                  durumu not alıp çalışmaya devam eder.

                  Siz ne zaman rapor ver derseniz TestNG yaptığı tüm assertion'ları gözden geçirir.
                  FAILED olan assertion'ları size raporlar ve FAILED olan varsa çalışmayı durdurur.

                    * soft assert objesi oluştur.
                    * tüm aseertion ları soft assertion objesi kullanarak yap
                    * assertionlar bitince "assertAll" ile raporla
         */

        // test otomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        SoftAssert softAssert = new SoftAssert();
        // Title'in Test icerdigini test edin
        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik),"Title Test içermiyor.");

        // url'in https://www.testotomasyonu.com oldugunu test edin
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Url beklenenden farklı.");

        // arama kutusunun kullanilabilir durumda oldugunu test edin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        softAssert.assertTrue(testOtomasyonuPage.aramaKutusu.isEnabled(), "arama kutusu kullanılamiyor.");

        // belirlenmis aranacak kelimeyi aratip urun bulundugunu test edin
        testOtomasyonuPage
                .aramaKutusu
                .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        int bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(bulunanSonucSayisi>0,"kayıtlı kelime arandığında ürün bulunamadı.");

        // Nutella aratip, urun bulunamadigini test edin
        ReusableMethods.bekle(2);

        testOtomasyonuPage.aramaKutusu.clear();
        testOtomasyonuPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        bulunanSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        softAssert.assertTrue(bulunanSonucSayisi==0,"Nutella bulundu.");

        softAssert.assertAll();

        // sayfayi kapatin
        Driver.closeDriver();

    }
}
