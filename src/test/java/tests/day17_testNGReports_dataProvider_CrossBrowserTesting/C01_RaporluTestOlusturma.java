package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static org.testng.Assert.assertTrue;

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void aramaTesti() {
        extentTest= extentReports.createTest("Arama Testi","Kullanıcı belirlenen kelimeyi aratıp, doğru arama yapıldığını test eder.");

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        extentTest.info("kullanıcı testotomasyonu anasayfasına gider");

        // belirlenen arama kelimesi için arama yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);

        extentTest.info("belirlenen arama kelimesi için arama yapar ");

        // arama sonucunda ürün bulunabildiğini test edin
        int aramaSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        assertTrue(aramaSonucSayisi>0);

        extentTest.pass("arama sonucunda ürün bulunduğunu test eder.");

        ReusableMethods.bekle(2);
        // ilk ürünü tıklayın
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk ürüne tıklar");
        // açılan ürün sayfasında ürün isminin
        // case sensitive olmadan belirlenen arama kelimesi içerdiğini test edin.
        String actualUrunIsmiKucukHarf = testOtomasyonuPage
                                            .urunSayfasindakiUrunIsimElementi
                                            .getText()
                                            .toLowerCase();
        assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));

        extentTest.pass("açılan ürün sayfasında ürün isminin\ncase sensitive olmadan belirlenen arama kelimesi içerdiğini test eder");
        Driver.quitDriver();
        extentTest.info("sayfayı kapatır.");
    }
}
