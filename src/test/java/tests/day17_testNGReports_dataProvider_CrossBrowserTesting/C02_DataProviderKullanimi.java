package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_DataProviderKullanimi extends TestBaseRapor {

    /*
        Bugüne kadar öğrendiğimiz yöntemlerle, birden fazla elemen için test yapmak istediğimizde elemenları bir arraye
        atayıp, forloop ile testleri yapmak istedik.
        Ancak,
        ilk failed olan urunde, assert,on exceptiın firlatıp çalışmayı durdurdu
        geriye kalan ürünlerin var olup olmadığını kontrol etmedi.

     */

    @Test
    public void cokluAramaTesti() {
        String[] aranacakUrunler = {"phone","java","dress","nutella","chair","tea"};
        String arananUrun;
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        int actualUrunSayisi ;

        for (int i = 0; i < aranacakUrunler.length; i++) {
            arananUrun=aranacakUrunler[i];

            // testotomasyonu anasayfaya gidin
            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

            // verilen urun listesindeki tum urunler icin arama yapip
            // urun listesi : phone, java, dress, nutella, chair, tea
            testOtomasyonuPage.aramaKutusu.sendKeys(arananUrun+ Keys.ENTER);

            // her bir urun icin arama yapildiginda sonuc bulunabildigini test edin
            actualUrunSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
            Assert.assertTrue(actualUrunSayisi>0);
        }

    }


    @DataProvider
    public static Object[][] aranacakUrunlerDataProvider() {
        // data provider, bize 2 katlı obje array'i döndüren bir method'dur.

        String[][] aranacakUrunler = {{"phone"},{"java"},{"dress"},{"nutella"},{"chair"},{"tea"}};

        return aranacakUrunler;
    }


    @Test(dataProvider = "aranacakUrunlerDataProvider")
    public void dataProviderIleCokluAramaTesti(String aranaUrun) {
        extentTest=extentReports.createTest("data provider testi","Belirlenen ürün");

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanıcı testotomasyonu anasayfaya gider");

        // verilen urun listesindeki tum urunler icin arama yapip
        // urun listesi : phone, java, dress, nutella, chair, tea

        testOtomasyonuPage.aramaKutusu.sendKeys( aranaUrun + Keys.ENTER);
        extentTest.info("verilen urun listesindeki " +aranaUrun + "için arama yapar");

        ReusableMethods.bekle(2);
        // her bir urun icin arama yapildiginda sonuc bulunabildigini test edin
        int actualUrunSayisi=testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(actualUrunSayisi>0);
        extentTest.pass(aranaUrun + "için arama yapıldığında urun bulunabildiğini test eder.");








    }




}
