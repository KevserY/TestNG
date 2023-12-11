package tests.day17_testNGReports_dataProvider_CrossBrowserTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderIleNegatifLoginTesti {

    @DataProvider
    public static Object[][] kullaniciBilgileriDP() {



        return new Object[][]{};
    }

    @Test(dataProvider = "kullaniciBilgileriDP")
    public void cokluNegatifLoginTesti(String username, String password) {

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestOtomasyonuPage testOtomasyonuPage =new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        // account linkine tiklayin

        // kullanici adi ve sifre olarak verilen listedeki
        // tum degerler icin giris yapilamadigini test edin

        // kullanici1   12345
        // kullanici2   23456
        // kullanici3   34567
        // kullanici4   45678
        // kullanici5   56789
        //


    }
}
